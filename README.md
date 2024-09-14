# BUCOL

Linguagem desenvolvida para a disciplina de compiladores, UFABC Q2 2024.

Autores | RA's: \
Pedro Paulo Ayala Yamada | 11202020731 \
Renato Sassaqui Moreira | 11201920581  

Baseado no [código disponibilizado](https://github.com/professorisidro/SimpleParser/tree/main) em aula.

## Editor highlight para VSCode
Para instalar o editor highlight, basta copia-lo para a pasta extensões do VSCode 

(LINUX)
```
cp -r bucol-extension/ ~/.vscode/extensions/
```

## Estruturação de um programa .bucol

### Estrutura geral do código
```bucol
poema <NOME_PROGRAMA>
    <DECLARACAO_VARIAVEIS>
inicio
    <COMANDOS>
fim
fimpoema
```
### Estrutura de declarações
#### Tipos de dados
* integr(o|a)(s): variáveis do tipo float (numérico), reconhecidas por números com ou sem ponto decimal
* verbos(o|a)(s): variáveis do tipo String, reconhecidos por parênteses `""`
* discret(o|a)(s): variáveis do tipo bool, as quais podem assumir valor:
    * `absoluto paraíso`, equivalente à true
    * `terrível inferno`, equivalente à false

#### Declaração
```
Atentai (à|ao)(s) <TIPO> <ID>
```

### Comandos
#### Leitura
```
<ID> ?
```

#### Escrita
Sem quebra de linha
```
Rogai ao mundo: <ID>
```
Com quebra de linha
```
Rogai ao mundo!: <ID>
```

#### Condicional
```
Ao acaso, tendo : <EXPR_COND>
    <COMANDOS_TRUE>
(OPCIONAL) Mas, se o destino não permite,  
(OPCIONAL)    <COMANDOS_FALSE>             
E esta é a solução para minhas indagações
```

#### Loop
Versão 1 (while):
```
Continuamente, ao caso de : <EXPR_COND>, busco 
    <COMANDOS>
O que continuamente trará meu sossego
```
Versão 2 (do While):
```
Busco 
    <COMANDOS>
Continuamente, em caso de : <EXPR_COND>
O que continuamente trará meu sossego
```

### Operadores
#### Condicionais
* `e também`: equivalente à "and"
* `ou também`: equivalente à "or"

#### Aritméticos
* `+`: adição
* `-`: subtração
* `*`: multiplicação
* `/`: divisão

### Expressão
```
<ID1> <OP> <ID2>
```


## Exemplo

O exemplo de código fonte está em `program.bucol`, no diretório raiz.

Para compila-lo é necessário utilizar o `antlr-4.13.2-complete.jar`, sendo possível realizar de maneira fácil utilizando o comando `bash run.sh` (LINUX).