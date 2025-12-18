import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
import os
import numpy as np

# configs visuais 
sns.set_theme(style="whitegrid", context="paper", font_scale=1.4)
plt.rcParams['figure.figsize'] = (12, 7)
plt.rcParams['axes.titlesize'] = 16
plt.rcParams['axes.labelsize'] = 14

# limpeza do dataset e carregamento
def carregar_dados():
    print("Carregando dados...")
    try:
        df = pd.read_csv('data/Projeto LEDA - benchmarks - Dados_Brutos .csv') 
        
        # removendo os ' ' das strings
        cols_str = ['ALGORITHM', 'DATA_SCENARIO', 'PROBLEMS', 'DATA_TYPE']
        for col in cols_str:
            if col in df.columns and df[col].dtype == 'O':
                df[col] = df[col].str.strip()

        # Tratamento do tempo
        if df['TIME_NS'].dtype == 'O': 
            df['TIME_NS'] = df['TIME_NS'].astype(str).str.replace('.', '', regex=False)
        df['TIME_NS'] = pd.to_numeric(df['TIME_NS'], errors='coerce')
        df['Tempo_ms'] = df['TIME_NS'] / 1_000_000
        
        # Se tiver erro (StackOverFlow), o tempo vira NaN para não afetar a média
        df['Has_Error'] = df['PROBLEMS'].notna() & (df['PROBLEMS'] != '')
        df.loc[df['Has_Error'], 'Tempo_ms'] = np.nan
        
        print(f" Dados processados. Total: {len(df)} registros.")
        return df
    except Exception as e:
        print(f"Erro : {e}")
        return None

# geração de tabela csv com as métricas de desempenho
def gerar_tabelas_detalhadas(df):
    print("\n Gerando Tabela Estatística")
    
    cols_group = ['ALGORITHM', 'DATA_TYPE', 'DATA_SCENARIO', 'SIZE_N']
    
    # Estatísticas de Tempo em Ms
    stats_ms = df.groupby(cols_group)['Tempo_ms'].agg(['mean', 'median', 'std', 'min', 'max']).reset_index()
    
    # Estatísticas de Tempo em Ns (necessário para os algoritmos de busca)
    stats_ns = df.groupby(cols_group)['TIME_NS'].agg(Media_NS='mean').reset_index()
    
    # Contagem de Sucessos e Falhas
    counts = df.groupby(cols_group)['Has_Error'].agg(Total='count', Falhas='sum').reset_index()
    counts['Sucessos'] = counts['Total'] - counts['Falhas']
    
    tabela_temp = pd.merge(stats_ms, stats_ns, on=cols_group)
    tabela_final = pd.merge(tabela_temp, counts, on=cols_group)
    
    tabela_final = tabela_final.rename(columns={
        'mean': 'Média (ms)',
        'median': 'Mediana (ms)',
        'std': 'DesvioPadrao (ms)',
        'min': 'Mínimo (ms)',
        'max': 'Máximo (ms)',
        'Media_NS': 'Média (ns)' 
    })
    
    cols_ms = ['Média (ms)', 'Mediana (ms)', 'DesvioPadrao (ms)', 'Mínimo (ms)', 'Máximo (ms)']
    tabela_final[cols_ms] = tabela_final[cols_ms].round(6)
    
    tabela_final['Média (ns)'] = tabela_final['Média (ns)'].round(0)
    
    if not os.path.exists('tabela'): os.makedirs('tabela')
    tabela_final.to_csv('tabela/estatisticas_benchmarck.csv', index=False)
    print(" Tabela salva: 'tabelas/estatisticas_benchmarck.csv'")
    
#gráficos
def plotar(df, algoritmos, titulo, arquivo, pasta, escala_log=False, tipo_dado='Object', cenario='random'):
    filtro = (
        (df['ALGORITHM'].isin(algoritmos)) & 
        (df['DATA_SCENARIO'] == cenario) &
        (df['DATA_TYPE'] == tipo_dado)
    )
    df_subset = df[filtro].copy()
    
    if df_subset.empty: return

    plt.figure()
    ax = plt.gca()
    
    sns.lineplot(
        data=df_subset, x='SIZE_N', y='Tempo_ms', hue='ALGORITHM', style='ALGORITHM',
        markers=True, dashes=False, linewidth=2.5, err_style="band", ci=95
    )
    

    erros = df_subset[df_subset['Has_Error'] == True]
    if not erros.empty:
        max_y = df_subset['Tempo_ms'].max()
        if pd.isna(max_y): max_y = 1
        y_pos = max_y * 1.2 if not escala_log else max_y * 5
        
        for algo in erros['ALGORITHM'].unique():
            erros_algo = erros[erros['ALGORITHM'] == algo]
            plt.scatter(
                x=erros_algo['SIZE_N'], y=[y_pos] * len(erros_algo),
                marker='X', s=100, c='red', zorder=10
            )
            for x_val in erros_algo['SIZE_N'].unique():
                plt.text(x_val, y_pos, "Falha", color='red', fontsize=10, ha='center', va='bottom')

    plt.title(f"{titulo} ({cenario})", fontweight='bold')
    plt.xlabel("Tamanho do Vetor (N)")
    plt.ylabel("Tempo (ms)")
    
    if escala_log:
        ax.set_yscale('log')
        plt.ylabel("Tempo (ms) - Escala Log")
        plt.grid(True, which="both", ls="-", alpha=0.2)

    plt.legend(bbox_to_anchor=(1.01, 1), loc='upper left', title="Algoritmo")
    plt.tight_layout()
    
    caminho_pasta = f'graficos/{pasta}'
    if not os.path.exists(caminho_pasta): os.makedirs(caminho_pasta)
    plt.savefig(f'{caminho_pasta}/{arquivo}_{cenario}.png', dpi=300)
    plt.close()
    print(f"   Generating: {caminho_pasta}/{arquivo}_{cenario}.png")

if __name__ == "__main__":
    df = carregar_dados()
    
    if df is not None:
        gerar_tabelas_detalhadas(df)
        
        quadráticos = ['BubbleSort_Simple', 'BubbleSort_Optimized', 'SelectionSort_Simple', 'SelectionSort_Stable', 'InsertionSort']
        log_lineares = ['MergeSort', 'QuickSort_Java', 'QuickSort_Simple', 'QuickSort_Shuffle', 'CountingSort']
        quicks_obj = ['QuickSort_Simple', 'QuickSort_Shuffle', 'QuickSort_Java']
        quicks_int = ['QuickSort_Simple', 'QuickSort_Shuffle', 'QuickSort_Java'] 
        buscas = ['Linear_Search_Iterative', 'Linear_Search_Recursive', 'Linear_Search_Two_Pointers', 'Binary_Search_Iterative', 'Binary_Search_Recursive']

        for cenario in ['random', 'Sorted', 'Reversed']:
            print(f"Processando cenário: {cenario}")
            
            plotar(df, quadráticos + log_lineares, "Visão Geral", "01_geral_log", "Ordenacao", escala_log=True, cenario=cenario)
            
            plotar(df, quadráticos, "Comparação Quadráticos", "02_quadraticos", "Ordenacao", cenario=cenario)
            
            plotar(df, log_lineares, "Comparação Log-Lineares", "03_log_lineares", "Ordenacao", cenario=cenario)
            
            plotar(df, quicks_obj, "Variações QuickSort (Objetos)", "04_quicks_obj", "Ordenacao", cenario=cenario)
            
            plotar(df, quicks_int, "QuickSort (Inteiros)", "05_quicks_int", "Ordenacao", tipo_dado='int', cenario=cenario)
            
            plotar(df, ['MergeSort', 'QuickSort_Shuffle'], "MergeSort vs QuickSort", "06_merge_vs_quick", "Ordenacao", cenario=cenario)

        print("\nPlotagem de Buscas...")
        plotar(df, buscas, "Algoritmos de Busca", "01_busca_geral_log", "Busca", escala_log=True, cenario='Sorted', tipo_dado='Object')
        
        plotar(df, ['Linear_Search_Iterative', 'Linear_Search_Recursive', 'Linear_Search_Two_Pointers'], 
               "Buscas Lineares", "02_busca_linear", "Busca", escala_log=False, cenario='Sorted', tipo_dado='Object')

        print("\n Concluído! Verifique as pastas 'graficos' e 'tabelas'.")