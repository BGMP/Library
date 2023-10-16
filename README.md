<h1>Library</h1>
<h2>Implementación</h2>
<p>
  Esta aplicación de Java Spring Boot fue escrita como resolución a la prueba técnica para desarrolladores planteada
  por la Sociedad Chilena de Autores e Intérpretes Musicales (SCD).
</p>
<p>
  La base de datos utilizada fue <b>H2</b> (volátil), y las entidades creadas para efectos de esta prueba fueron las siguientes:
</p>

<ul>
    <li><b>Author</b>: Representa autores, los cuales pueden estar relacionados con muchos libros distintos.</li>
    <li><b>Book</b>: Representa libros, los cuales sólo pueden estar relacionados con 1 autor.</li>
</ul>

<table>
    <thead>
    <tr>
        <th colspan="3">Author</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><b>Atributo</b></td>
        <td><b>Tipo</b></td>
        <td><b>Default</b></td>
    </tr>
    <tr>
        <td>id</td>
        <td>Long</td>
        <td>PK autonicremental</td>
    </tr>
    <tr>
        <td>name</td>
        <td>String (255)</td>
        <td>REQUERIDO</td>
    </tr>
    <tr>
        <td>last_name</td>
        <td>String (255)</td>
        <td>REQUERIDO</td>
    </tr>
    <tr>
        <td>books</td>
        <td>Set&lt;Book&gt;</td>
        <td>new HashSet<>()</td>
    </tr>
    </tbody>
</table>

<br/>

<table>
    <thead>
    <tr>
        <th colspan="3">Book</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><b>Atributo</b></td>
        <td><b>Tipo</b></td>
        <td><b>Default</b></td>
    </tr>
    <tr>
        <td>id</td>
        <td>Long</td>
        <td>PK autonicremental</td>
    </tr>
    <tr>
        <td>title</td>
        <td>String (255)</td>
        <td>REQUERIDO</td>
    </tr>
    <tr>
        <td>publication_date</td>
        <td>Date (dd-MM-yyyy)</td>
        <td>REQUERIDO</td>
    </tr>
    <tr>
        <td>pages</td>
        <td>Integer</td>
        <td>REQUERIDO</td>
    </tr>
    <tr>
        <td>price</td>
        <td>Float</td>
        <td>REQUERIDO</td>
    </tr>
    <tr>
        <td>hardcover</td>
        <td>Boolean</td>
        <td>false</td>
    </tr>
    <tr>
        <td>author</td>
        <td>Author</td>
        <td>REQUERIDO</td>
    </tr>
    </tbody>
</table>

<h2>Servicios REST</h2>

<p>La API fue diseñada para mantener actualizados los autores con sus libros correspondientes. Al eliminarse un
    autor con libros asociados, la eliminación es en cascada. Esto quiere decir que los libros asociados al autor
    eliminado también son eliminados de la base de datos.
</p>
<p>A continuación, se detallan ejemplos de cómo interactuar con la API implementada en sus diferentes endpoints:</p>

<h3>Author</h3>

<p>Crear (POST <code>http://localhost:8080/api/v1/authors</code>)</p>
<pre>
{
    "name": "Miguel",
    "lastName": "de Cervantes"
}
</pre>
<p>Leer todos (GET <code>http://localhost:8080/api/v1/authors</code>)</p>
<p>Leer uno (GET <code>http://localhost:8080/api/v1/authors/1</code>)</p>
<p>Eliminar (DELETE <code>http://localhost:8080/api/v1/authors/1</code>)</p>
<p>Actualizar (PUT <code>http://localhost:8080/api/v1/authors/1</code>)</p>
<pre>
{
    "name": "Julio",
    "lastName": "Verne"
}
</pre>

<h3>Book</h3>

<p>Crear (POST <code>http://localhost:8080/api/v1/books)</code></p>
<pre>
{
    "title": "El Quijote",
    "publicationDate": "01-01-1605",
    "pages": 1560,
    "price": 16.99,
    "hardcover": true,
    "author": {
        "id": 1
    }
}
</pre>
<p>Leer todos (GET <code>http://localhost:8080/api/v1/books)</code></p>
<p>Leer uno (GET <code>http://localhost:8080/api/v1/books/1)</code></p>
<p>Eliminar (DELETE <code>http://localhost:8080/api/v1/books/1)</code></p>
<p>Actualizar (PUT <code>http://localhost:8080/api/v1/books/1)</code></p>
<pre>
{
    "title": "El Quijote",
    "publicationDate": "01-01-1605",
    "pages": 1560,
    "price": 40.99,
    "hardcover": false,
    "author": {
        "id": 1
    }
}
</pre>
