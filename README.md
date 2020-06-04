# tio-dev-web-artigos
trabalho interdisciplinar do 6° semestre da UniDrummond Ciências da Computação
<h2>GETs</h2>
<h3>GET de todos</h3>
<p>Para o retorno de todos os artigos, utilize o verbo HTTP GET e a URI abaixo</P>
http://localhost:8801/artigos
<p>Vai gerar o retorno abaixo</p>
<pre>
  [
  {
    "id": 1,
    "titulo": "teste titulo",
    "area": "teste area",
    "hiperLink": "teste link",
    "dataPublicacao": "2020-06-02"
  },
  {
    "id": 2,
    "titulo": "teste titulo",
    "area": "teste area",
    "hiperLink": "teste link",
    "dataPublicacao": "2020-06-02"
  },
  {
    "id": 3,
    "titulo": "teste titulo",
    "area": "teste area",
    "hiperLink": "teste link",
    "dataPublicacao": "2020-06-02"
  }
]
</pre>
<h3>GET por ID</h3>
<p>para o retorno de um resgistro pelo seu ID, utilize o verbo HTTP GET com a URI abaixo, no caso trazendo o registro de ID 1</p>
http://localhost:8801/artigos/1
<p>Vai gerar o retorno abaixo</p>
<pre>
{
  "id": 1,
  "titulo": "teste titulo",
  "area": "teste area",
  "hiperLink": "teste link",
  "dataPublicacao": "2020-06-02"
}
</pre>
<h2>POST</h2>
<p>Para cadastrar uma artigo, utilize o verbo HTTP POST utlizando a seguinte URI abaixo</p>
http://localhost:8801/artigos
<p>E passando um JSON como no exemplo no corpo  da requisição, seguindo as mesmas chaves só modificando valor</p>
<pre>
{
  "titulo": "teste titulo",
  "area": "teste area",
  "hiperLink": "teste link",
	"dataPublicacao": "2020-06-03"
}
</pre>
<p>e tendo o retorno abaixo</p>
<pre>
{
  "id": 3,
  "titulo": "teste titulo",
  "area": "teste area",
  "hiperLink": "teste link",
  "dataPublicacao": "2020-06-02"
}
</pre>
<h2>PUT</h2>
<p>Para alterar uma artigo, utilize o verbo HTTP PUT utlizando a seguinte URI abaixo, no caso modificando o artigo de ID 1</p>
http://localhost:8801/artigos/1
<p>E passando um JSON como no exemplo no corpo  da requisição, seguindo as mesmas chaves só modificando valor</p>
<pre>
{
  "titulo": "teste titulo",
  "area": "teste area",
  "hiperLink": "teste link",
	"dataPublicacao": "2020-06-03"
}
</pre>
<p>e tendo o retorno abaixo</p>
<pre>
{
  "id": 1,
  "titulo": "teste titulo alterado",
  "area": "teste area",
  "hiperLink": "teste link",
  "dataPublicacao": "2020-06-02"
}
</pre>
<h2>Delete</h2>
<p>Para apagar um artigo, utlize o verbo HTTP DELETE e utilizando a URI abaixo, que no caso será apagado o artigo com ID 1</p>
http://localhost:8801/artigos/1
<p>e tendo o retorno abaixo</p>
O artigo teste titulo alterado foi apagado
