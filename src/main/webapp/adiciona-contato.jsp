<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="minhasTags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Adicionar contato</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>

        <div class="container">

            <form action="sistema" method="get">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome" placeholder="nome">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="email">E-mail</label>
                        <input type="email" class="form-control" id="email" placeholder="email@email.com">
                    </div>
                </div>
                 <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="endereco">Endereço</label>
                        <input type="text" class="form-control" id="endereco" placeholder="endereco">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="dataNascimento">Data Nascimento</label>
                        <input type="date" class="form-control" id="dataNascimento" placeholder="11/01/2000">
                    </div>
                </div>
                <div class="form-row">
                    <minhasTags:tagCriada id="enviar" value="Enviar"/>
                </div>
            </form>

        </div>


        <c:import url="rodape.jsp"/>
    </body>