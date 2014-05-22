<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
    Document   : categoria
    Created on : 12-mar-2014, 16:48:46
    Author     : Administrador
--%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">




<div id="categoryLeftColumn">

    <c:forEach var="categoriaVista" items="${categorias}">
        <c:choose>
            <c:when test="${categoriaVista.id==categoriaSeleccionada.id}">
                <div class="categoryButton" id="selectedCategory">
                    <span class="categoryText">${categoriaVista.nombre}</span>
                </div>
            </c:when>
            <c:otherwise>
                <a href="category?categoryId=${categoriaVista.id}" class="categoryButton">
                    <span class="categoryText">${categoriaVista.nombre}</span>
                </a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>

<div id="categoryRightColumn">
    <p id="categoryTitle">${categoriaSeleccionada.nombre}</p>

    <table id="productTable">

        <c:forEach var="productoVista" items="${listaProductos}">
            <tr>
                <td class="lightBlue">
                    <img src="${initParam.productImagePath}/${productoVista.imagen}" alt="product image">
                </td>
                <td class="lightBlue">
                    ${productoVista.nombre}
                    <br>
                    <span class="smallText">${productoVista.descripcion}</span>
                </td>
                <td class="lightBlue">${productoVista.precio}</td>
                <td class="lightBlue">
                    <form action="addToCart" method="post">
                        <input type="submit" value="comprar">
                    </form>
                </td>
            </tr>

        </c:forEach>

        <!--
        <tr>
            <td class="white">
                <img src="#" alt="product image">
            </td>
            <td class="white">
                [ nombre producto ]
                <br>
                <span class="smallText">[ descripcion producto ]</span>
            </td>
            <td class="white">[ precio ]</td>
            <td class="white">
                <form action="addToCart" method="post">
                    <input type="submit" value="comprar">
                </form>
            </td>
        </tr>

        <tr>
            <td class="lightBlue">
                <img src="#" alt="product image">
            </td>
            <td class="lightBlue">
                [ nombre producto ]
                <br>
                <span class="smallText">[ descripcion producto ]</span>
            </td>
            <td class="lightBlue">[ precio ]</td>
            <td class="lightBlue">
                <form action="addToCart" method="post">
                    <input type="submit" value="comprar">
                </form>
            </td>
        </tr>

        <tr>
            <td class="white">
                <img src="#" alt="product image">
            </td>
            <td class="white">
                [ nombre producto ]
                <br>
                <span class="smallText">[ descripcion producto ]</span>
            </td>
            <td class="white">[ precio ]</td>
            <td class="white">
                <form action="addToCart" method="post">
                    <input type="submit" value="Comprar">
                </form>
            </td>
        </tr>
        
        -->
    </table>
</div>


