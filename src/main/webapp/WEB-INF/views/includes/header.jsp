<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<<<<<<< HEAD
<<<<<<< HEAD
           <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        
        <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
            <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#">Company name</a>
        </header>
=======
=======
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="segment" value="${requestScope['javax.servlet.forward.servlet_path']}" />
>>>>>>> 9210ab401d820aad1df98bad2a74a82831c93f90
<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#">Company name</a>
</header>
>>>>>>> 457e3ca7769cbac2906710120786be81e281095b

<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
    <div class="position-sticky pt-3 d-flex flex-column flex-shrink-0 p-3 text-white bg-dark"
        style="width: 100%; height: 100% ;">
        <a href="/"
            class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
            <svg class="bi pe-none me-2" width="40" height="32">
                <use xlink:href="#bootstrap" />
            </svg>
            <span class="fs-4">ERP</span>
        </a>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath }/" id="home" class='nav-link text-white'
                    aria-current="page">
                    <svg class="bi pe-none me-2" width="16" height="16">
                        <use xlink:href="#home" />
                    </svg>
                    HOME
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }#" id="employee" class="nav-link text-white">
                    <svg class="bi pe-none me-2" width="16" height="16">
                        <use xlink:href="#speedometer2" />
                    </svg>
                    인사관리
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }#" class="nav-link text-white">
                    <svg class="bi pe-none me-2" width="16" height="16">
                        <use xlink:href="#table" />
                    </svg>
                    부서관리
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/schedule" id="schedule"
                    class='nav-link text-white ${fn:split(segment, ' /')[0] eq "schedule" ? "active" : ""
                    }'>
                    <svg class="bi pe-none me-2" width="16" height="16">
                        <use xlink:href="#grid" />
                    </svg>
                    달력
                </a>
            </li>

            <li>
                <a href="${pageContext.request.contextPath }/notice" id="notice"
                    class='nav-link text-white ${fn:split(segment, ' /')[0] eq "notice" ? "active" : "" }'>
                    <svg class="bi pe-none me-2" width="16" height="16">
                        <use xlink:href="#people-circle" />
                    </svg>
                    공지사항
                </a>
            </li>
            <li>
                <a href="#" class="nav-link text-white">
                    <svg class="bi pe-none me-2" width="16" height="16">
                        <use xlink:href="#people-circle" />
                    </svg>
                    지출관리
                </a>
            </li>
        </ul>
        <hr>
        <div class="dropdown">
            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
                id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="https://github.com/mdo.png" alt="" width="32" height="32"
                    class="rounded-circle me-2">
                <strong></strong>
            </a>
            <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                <li><a class="dropdown-item" href="#">New project...</a></li>
                <li><a class="dropdown-item" href="#">Settings</a></li>
                <li>
                    <div class="dropdown-item" data-action="profile">Profile</div>
                </li>
                <li>
                    <hr class="dropdown-divider">
                </li>
                <li>
                    <div class="dropdown-item" data-action="logout">Sign out</div>
                </li>
            </ul>
        </div>
    </div>
    <script>
        $(function () {
            let employeeIdx ="";
            let name="";
            var requestOptions = {
                method: 'GET',
                redirect: 'follow'
            };

            fetch("http://localhost:8080/api/employee/info", requestOptions)
                .then(response => response.json())
                .then(result => {    
                	console.log(result);
                    employeeIdx = result.employeeIdx;
                    name = result.name;    
                    $('.rounded-circle').after("<strong>"+name+"</strong>");              
                })
                .catch(error => console.log('error', error));

            var pathname = $(location).attr('pathname');
            console.log(pathname);
            if (pathname === "/") {
                $('#home :nth-child(1)').toggle("nav-link text-white");
                $('#home :nth-child(1)').toggle("nav-link active");
                $('#home').addClass("nav-link text-white");
                $('#home').addClass("nav-link active");
            }
            if (pathname === "/notice") {
                $('#notice :nth-child(1)').toggle("nav-link text-white");
                $('#notice :nth-child(1)').toggle("nav-link active");

            }
            if (pathname === "/schedule") {
                $('#schedule :nth-child(1)').toggle("nav-link text-white");
                $('#schedule :nth-child(1)').toggle("nav-link active");

            }
            if (pathname === "/board") {
                $('#home :nth-child(1)').toggle("nav-link text-white");
                $('#home :nth-child(1)').toggle("nav-link active");
            }

            //logout
            $(".dropdown-item").on("click", function () {
                let action = $(this).data("action");
                console.log(action);
                if (action === "logout") {

                    var requestOptions = {
                        method: 'POST',
                        redirect: 'follow'
                    };

                    fetch("http://localhost:8080/api/logout", requestOptions)
                        .then(response => response.json())
                        .then(result => {

                            if (result.result == true) {
                                location.href = "/login";
                            }
                        })
                        .catch(error => console.log('error', error));
                }
                if (action === "profile") {
                    location.href ="/user/"+employeeIdx;
                }
            });
        });
    </script>
</nav>