<%-- 
    Document   : index
    Created on : 12-mar-2014, 16:48:46
    Author     : Administrador
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


    <div id="indexLeftColumn">
        <div id="welcomeText">
            <p>[ mensaje de bienvenida ]</p>
            
            
        </div>
    </div>

    <div id="indexRightColumn">
        <c:forEach var="categoria" items="${categorias}">
            <div class="categoryBox">
                <a href="category?categoryId=${categoria.id}">
                     <span class="categoryLabel">${categoria.id}</span>
                    <span class="categoryLabelText">${categoria.nombre}</span>
                </a>
            </div>
        </c:forEach>
 
    </div>
    




