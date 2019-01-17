# Problema do Barbeiro Dorminhoco

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Estudo dirigido feito em `Java` para a disciplina de **Sistemas Operacionais II** do curso de [Engenharia de Computação](https://pcs.ifsuldeminas.edu.br/index.php?option=com_content&view=article&id=639&Itemid=267) do [IFSULDEMINAS - Campus Poços de Caldas](https://pcs.ifsuldeminas.edu.br/). <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dentre diversas soluções que podem ser implementadas para esse problema, nesse repositório será apresentada a solução utilizando o conceito de *threads*.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O problema do **barbeiro dorminhoco** consiste no que se segue:<br>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A barbearia tem:<br>
- um **barbeiro**
- uma **cadeira de barbeiro**
- **algumas cadeiras** para os fregueses **esperarem**<br>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Se o movimento estiver fraco (nenhum freguês), o barbeiro senta na sua cadeira e dorme;<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Quando um freguês chega no salão vazio, ele tem que acordar o barbeiro;<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Se outros fregueses chegam enquanto o barbeiro está ocupado, eles:<br>
- Sentam na cadeira de espera
- Vão embora, se não houver cadeira vazia

# Implementação da solução
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A implementação conta com um **semáforo principal** que é a **abstração** da cadeira do barbeiro. Cada cliente a espera de sua vez, é, na verdade, uma *thread* que tenta adquirir o semáforo. Sempre que uma *thread* libera o semáforo, uma nova *thread* adquire tal semáforo, saindo da fila de espera e liberando uma vaga em tal fila.

# Imagens do Software

<p align = "center">
  <img src="https://raw.githubusercontent.com/MarcosVMoreira/Problema-do-Barbeiro-Dorminhoco/master/Imagens%20do%20sistema/In%C3%ADcio.png" alt="Início" />
</p>      <br>
<p align = "center">
  <img src="https://raw.githubusercontent.com/MarcosVMoreira/Problema-do-Barbeiro-Dorminhoco/master/Imagens%20do%20sistema/EmExecucao.png" alt="Em execução"/>
</p>     <br> 


# Pré-Requisitos

- Java 8 ou superior.
- JDK 10.0 ou superior.

# Instalação

Basta clonar/baixar os arquivos do repositório e abri-los utilizando NetBeans IDE.

# Equipe

* **Marcos Vinícius Moreira** - *Desenvolvedor do Software* - [MarcosVMoreira](https://github.com/MarcosVMoreira)
* **Otávio Palma** - *Desenvolvedor do Software* - [OtavioPalma](https://github.com/OtavioPalma)
