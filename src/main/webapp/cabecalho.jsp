<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="mb-2">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">
        <!-- c:url utilizado para referenciar o caminho absoluto do projeto ao endereço acessado  -->
        <!-- exemplo: fj21/imagens/postgres.png -->
            <img src="<c:url value="/imagens/postgres.png"/>" width="75" height="50" alt="">
        </a>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Implementação de JAVA EE + POSTGRES + JSTL + EL <span class="sr-only">(current)</span></a>
                </li>
            </ul>
        </div>
    </nav>
</header>