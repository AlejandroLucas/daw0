<%--
    Document   : verificar
    Created on : 12-mar-2014, 16:48:46
    Author     : Administrador
--%>

<%@page errorPage="../error.jsp" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">



 <div id="singleColumn">

        <h2>Pedido</h2>

        <p>Para comprar los productos de tu carrito de la compra, necesitamos la siguiente informacion:</p>

        <form action="#" method="post">
            <table id="checkoutTable">
                <tr>
                    <td><label for="nombre">Nombre</label></td>
                    <td class="inputField">
                        <input type="text"
                               size="31"
                               maxlength="45"
                               id="nombre"
                               name="nombre">
                    </td>
                </tr>
                <tr>
                    <td><label for="email">Email:</label></td>
                    <td class="inputField">
                        <input type="text"
                               size="31"
                               maxlength="45"
                               id="email"
                               name="email">
                    </td>
                </tr>
                <tr>
                    <td><label for="telefono">Telefono</label></td>
                    <td class="inputField">
                        <input type="text"
                               size="31"
                               maxlength="16"
                               id="telefono"
                               name="telefono">
                    </td>
                </tr>
                <tr>
                    <td><label for="direcion">Direcion</label></td>
                    <td class="inputField">
                        <input type="text"
                               size="31"
                               maxlength="45"
                               id="direcion"
                               name="direcion">

                        <br>
                        Barcelona
                   
                </td>
            </tr>
            <tr>
                <td><label for="tarjeta:">Tarjeta:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="19"
                           id="tarjeta"
                           name="tarjeta">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="comprar">
                </td>
            </tr>
        </table>
    </form>

    <div id="infoBox">

        <ul>
            <li>Entregamos el dia siguente</li>
            <li>Se aplican unos &euro; [gastos de spedicion]
                para los gastos de envio</li>
        </ul>

        <table id="priceBox">
            <tr>
                <td>Subtotal:</td>
                <td class="checkoutPriceColumn">
                    &euro; [subtotale carrito de la compra]</td>
            </tr>
            <tr>
                <td>Gastos envios:</td>
                <td class="checkoutPriceColumn">
                    &euro; [gastos de spedicion] </td>
            </tr>
            <tr>
                <td class="total">Total:</td>
                <td class="total checkoutPriceColumn">
                    &euro; [total ]</td>
            </tr>
        </table>
    </div>
</div>
           