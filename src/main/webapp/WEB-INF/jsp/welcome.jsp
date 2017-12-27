<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE>
<html>
<head>
    <title>${appName}</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Backend Course for frontend developers">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha256-eZrrJcwDc/3uDhsdt61sL2oOBY362qM3lon1gyExkL0=" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.1/css/bulma.css" integrity="sha256-lUssH++umYLC/97WXqr424ew3ing8e+dATTAmMpCF40=" crossorigin="anonymous" />

    <link rel="stylesheet" type="text/css" href="static/css/style.css?v=${appVersion}">
</head>
<body>
<section class="hero is-info is-medium is-bold">
    <div class="hero-head">
        <nav class="navbar">
            <div class="container">
                <div class="navbar-brand">
                    <a class="navbar-item" href="#">
                        <i class="fa fa-laptop logo_custom" aria-hidden="true"></i>
                        ${fn:toUpperCase(appName)}
                    </a>
                    <span class="navbar-burger burger" data-target="navbarMenu">
              <span></span>
              <span></span>
              <span></span>
            </span>
                </div>
                <div id="navbarMenu" class="navbar-menu">
                    <div class="navbar-end">
                        <a class="navbar-item is-active">
                            Home
                        </a>
                        <a class="navbar-item">
                            Examples
                        </a>
                        <a class="navbar-item">
                            Documentation
                        </a>
                        <span class="navbar-item">
                <a class="button is-white is-outlined is-small" href="https://github.com/dansup/bulma-templates/blob/master/templates/hero.html">
                  <span class="icon">
                    <i class="fa fa-github"></i>
                  </span>
                  <span>View Source</span>
                </a>
              </span>
                    </div>
                </div>
            </div>
        </nav>
    </div>
    <div class="hero-body">
        <div class="container has-text-centered">
            <h1 class="title">
                Hello, World!
            </h1>
            <h2 class="subtitle">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
            </h2>
            <i class="fa fa-chevron-down" aria-hidden="true"></i>
        </div>
    </div>
</section>

<section class="container">
    <c:set var="opened" value="false"/>
    <c:forEach items="${articleList}" var="article" varStatus="iteration">
        <c:if test="${((iteration.first or iteration.count % 3 eq 0) and not opened) or not opened}">
            <div class="columns features">
            <c:set var="opened" value="true"/>
        </c:if>
                <div class="column is-4">
                    <div class="card">

                        <div class="card-image has-text-centered">
                            <figure class="image is-4by3">
                                <img src="${article.picture}" alt="Image" />
                            </figure>
                        </div>
                        <div class="card-content">
                            <div class="content">
                                <h4>${article.title}</h4>
                                <p>${article.plot}</p>
                                <p>
                                    <span>${article.tag}</span>
                                </p>
                                <p hidden>${article.id}</p>
                            </div>
                        </div>
                    </div>
                </div>
        <c:if test="${iteration.count % 3 eq 0}">
            </div>
            <c:set var="opened" value="false"/>
        </c:if>
    </c:forEach>

</section>
<hr>
<footer class="footer">
    <p><i class="fa fa-copyright" aria-hidden="true"></i>2017 Company, Inc      v.${appVersion}</p>
</footer>
</body>
</html>