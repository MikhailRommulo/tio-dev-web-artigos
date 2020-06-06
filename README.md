# tio-dev-web-artigos
trabalho interdisciplinar do 6° semestre da UniDrummond Ciências da Computação
<h2>GETs</h2>
<h3>GET de todos</h3>
<p>Para o retorno de todos os artigos, utilize o verbo HTTP GET e a URI abaixo</P>
https://tio-dev-web.herokuapp.com/artigos
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
https://tio-dev-web.herokuapp.com/artigos/1
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
<h3>GET entre intervalo de datas</h3>
<p>para o retorno de registros entre datas, utilize o verbo HTTP GET com a URI abaixo, no caso trazendo os registros entre 01/05/2019 e 31/05/2019</p>
https://tio-dev-web.herokuapp.com/artigos/datas?from=2019-05-01&to=2019-05-31
<pre>
[
  {
    "id": 5,
    "titulo": "teste data 2",
    "area": "teste area 2",
    "hiperLink": "teste link data 2",
    "dataPublicacao": "2019-05-04"
  },
  {
    "id": 6,
    "titulo": "teste data 3",
    "area": "teste area 3",
    "hiperLink": "teste link data 3",
    "dataPublicacao": "2019-05-15"
  }
]
</pre>
<h3>GET por título ou área</h3>
<p>para o retorno dos registros por seu valor parcial de título ou área, utilize o verbo HTTP GET com a URI abaixo, no caso retornando os que  possuem "at" em alguma parte de título ou área</p>
https://tio-dev-web.herokuapp.com/artigos//titulo-area?search=at
<pre>
[
  {
    "id": 4,
    "titulo": "teste data 1",
    "area": "teste area 1",
    "hiperLink": "teste link data 1",
    "dataPublicacao": "2019-06-04"
  },
  {
    "id": 5,
    "titulo": "teste data 2",
    "area": "teste area 2",
    "hiperLink": "teste link data 2",
    "dataPublicacao": "2019-05-04"
  },
  {
    "id": 6,
    "titulo": "teste data 3",
    "area": "teste area 3",
    "hiperLink": "teste link data 3",
    "dataPublicacao": "2019-05-15"
  }
]
</pre>
<h3>GET pelo link</h3>
<p>para o retorno de registros por seu link, utilize o verbo HTTP GET com a URI abaixo, no caso retornando o artigo com o link "teste link 3"</p>
https://tio-dev-web.herokuapp.com/artigos/link?link=teste link 3
<pre>
{
  "id": 3,
  "titulo": "teste titulo 3",
  "area": "teste area 3",
  "hiperLink": "teste link 3",
  "dataPublicacao": "2020-06-04"
}
</pre>
<h3>GET por titulo ou área, pela data</h3>
<p>para o retorno de registros por data, e seu título ou área, utilize o verbo HTTP GET com a URI abaixo, no caso retornando os artigos com "es" em alguma parte do título ou área, e pertecendo ao intervalo de 04/05/2019 e 31/05/2019</p>https://tio-dev-web.herokuapp.com/artigos/titulo-area-datas?search=es&from=2019-05-04&to=2019-05-3
<pre>
[
  {
    "id": 5,
    "titulo": "teste data 2",
    "area": "teste area 2",
    "hiperLink": "teste link data 2",
    "dataPublicacao": "2019-05-04"
  },
  {
    "id": 6,
    "titulo": "teste data 3",
    "area": "teste area 3",
    "hiperLink": "teste link data 3",
    "dataPublicacao": "2019-05-15"
  }
]
</pre>
<h2>POST</h2><p>Para cadastrar uma artigo, utilize o verbo HTTP POST utlizando a seguinte URI abaixo</p>
https://tio-dev-web.herokuapp.com/artigos
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
https://tio-dev-web.herokuapp.com/artigos/1
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
https://tio-dev-web.herokuapp.com/artigos/1
<p>e tendo o retorno abaixo</p>
O artigo teste titulo alterado foi apagado
