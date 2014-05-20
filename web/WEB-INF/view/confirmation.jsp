<%--
    Document   : confirmar
    Created on : 12-mar-2014, 16:48:46
    Author     : Administrador
--%>
<%@page errorPage="../error.jsp" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="header.jsp"></jsp:include>


    <div id="singleColumn">

        <p id="confirmationText">
            <strong>Tu orden ha sido procesado y será entregado en un plazo de 24 horas.</strong>
            <br><br>
            Tu numero de pedido es:
            <strong>[ número de referencia ]</strong>
            <br>
            Si tienes algunas preguntas en relación a tu pedido, <a href="#">contactanos</a>.
            <br><br>
            Gracias por comprar en nuestra tienda!

        </p>

        <div class="summaryColumn" >

            <table id="orderSummaryTable" class="detailsTable" >
                <tr class="header">
                    <th colspan="3">[ detalles de la compra ]</th>
                </tr>
                <tr class="tableHeading">
                    <td>producto</td>
                    <td>cuantidad</td>
                    <td>precio</td>
                </tr>
                <tr class="lightBlue">
                    <td>
                        [nombre producto]
                    </td>
                    <td class="quantityColumn">
                        [cuantidad]
                    </td>
                    <td class="confirmationPriceColumn">
                        &euro; [precio]
                    </td>
                </tr>
                <tr class="white">
                    <td>[nombre producto]</td>
                    <td class="quantityColumn">
                        [cuantidad]
                    </td>
                    <td class="confirmationPriceColumn">
                        &euro; [precio]
                    </td>
                </tr>


                <tr class="lightBlue">
                    <td colspan="3" style="padding: 0 20px"><hr>
                    </td>
                </tr>

                <tr class="lightBlue">
                    <td colspan="2" id="deliverySurchargeCellLeft">
                        <strong>Gastos de spedicion:</strong>
                    </td>
                    <td id="deliverySurchargeCellRight">
                        &euro; [gastos de spedicion]
                    </td>
                </tr>

                <tr class="lightBlue">
                    <td colspan="2" id="totalCellLeft">
                        <strong>total:</strong>
                    </td>
                    <td id="totalCellRight">
                        &euro; [total orden]
                    </td>
                </tr>

                <tr class="lightBlue">
                    <td colspan="3" style="padding: 0 20px"><hr>
                    </td>
                </tr>

                <tr class="lightBlue">
                    <td colspan="3" id="dateProcessedRow">
                        <strong>Fecha pedido:</strong>
                        [fecha orden]
                    </td>
                </tr>
            </table>

        </div>

        <div class="summaryColumn" >

            <table id="deliveryAddressTable" class="detailsTable">
                <tr class="header">
                    <th colspan="3">Detalles del envio</th>
                </tr>

                <tr>
                    <td colspan="3" class="lightBlue">
                        [nombre cliente]
                        <br>
                        [direcion cliente]
                        <br>
                        Barcelona  [comarca cliente]
                        <br>
                        <hr>
                        <strong>email:</strong>  [email cliente]
                        <br>
                        <strong>telefono</strong>  [telefono cliente]
                    </td>
                </tr>
            </table>

        </div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>