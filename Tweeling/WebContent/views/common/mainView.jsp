<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<style>
    
</style>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <link rel="stylesheet" href="css/mainView.css">
        <style>
            .carousel-inner img {
                width: 100%;
                height: 100%;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div id="carousel-heading" class="section-heading" align="center">
                <h2>CELEB</h2>
                <span>Details to details is what makes Tweeling different from the other shops.</span>
                <br><br>
            </div>
            <div id="main-carousel" class="carousel slide" data-ride="carousel">
                <ul class="carousel-indicators">
                    <li data-target="#main-carousel" data-slide-to="0" class="active"></li>
                    <li data-target="#main-carousel" data-slide-to="1"></li>
                    <li data-target="#main-carousel" data-slide-to="2"></li>
                    <li data-target="#main-carousel" data-slide-to="3"></li>
                    <li data-target="#main-carousel" data-slide-to="4"></li>
                    <li data-target="#main-carousel" data-slide-to="5"></li>
                </ul>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <a href="/Tweeling/agAllList.pro">
                            <img src="resources/mainView_resources/ariana.jpg" alt="ag">
                            <div class="carousel-caption">
                                <h2>Ariana Grande</h2>
                                <br><br>
                            </div>
                        </a>
                    </div>
                    <div class="carousel-item">
                        <a href="/Tweeling/dcAllList.pro">
                            <img src="resources/mainView_resources/doja.jpg" alt="dc">
                            <div class="carousel-caption">
                                <h2>Doja Cat</h2>
                                <br><br>
                            </div>
                        </a>
                    </div>
                    <div class="carousel-item">
                        <a href="/Tweeling/dlAllList.pro">
                            <img src="resources/mainView_resources/dua.jpg" alt="dl">
                            <div class="carousel-caption">
                                <h2>Dua Lipa</h2>
                                <br><br>
                            </div>
                        </a>
                    </div>
                    <div class="carousel-item">
                        <a href="/Tweeling/jbAllList.pro">
                            <img src="resources/mainView_resources/justin.jpg" alt="jb">
                            <div class="carousel-caption">
                                <h2>Justin Bieber</h2>
                                <br><br>
                            </div>
                        </a>
                    </div>
                    <div class="carousel-item">
                        <a href="/Tweeling/tsAllList.pro">
                            <img src="resources/mainView_resources/taylor.jpg" alt="ts">
                            <div class="carousel-caption">
                                <h2>Taylor Swift</h2>
                                <br><br>
                            </div>
                        </a>
                    </div>
                    <div class="carousel-item">
                        <a href="/Tweeling/wdwAllList.pro">
                            <img src="resources/mainView_resources/why.jpg" alt="wdw">
                            <div class="carousel-caption">
                                <h2>Why Don't We</h2>
                                <br><br>
                            </div>
                        </a>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#main-carousel" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#main-carousel" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>
            <div class="main-banner" id="top">
                <div class="section-heading" align="center">
                    <h2>OUR PRODUCTS</h2>
                    <span>Details to details is what makes Tweeling different from the other shops.</span>
                    <br><br>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="left-content">
                            <div class="thumb" id="main-products-big">
                                <div class="inner-content">
                                    <h4>PRODUCTS</h4>
                                    <span>Awesome, creative &amp; exclusive products</span>
                                    <div class="main-border-button">
                                        <a href="/Tweeling/allList.pro">Browse ALL</a>
                                    </div>
                                </div>
                                <img src="resources/mainView_resources/products.jpg">
                            </div>
                            <br>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="right-content">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="right-first-image">
                                        <div class="thumb">
                                            <div class="inner-content">
                                                <h4>MUSIC</h4>
                                            </div>
                                            <div class="hover-content">
                                                <div class="inner">
                                                    <h4>MUSIC</h4>
                                                    <p>Music is our pride and joy</p>
                                                    <div class="main-border-button">
                                                        <a href="/Tweeling/musicList.pro">Browse MUSIC</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <img src="resources/mainView_resources/music.jpg">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="right-first-image">
                                        <div class="thumb">
                                            <div class="inner-content">
                                                <h4>CLOTHING</h4>
                                            </div>
                                            <div class="hover-content">
                                                <div class="inner">
                                                    <h4>CLOTHING</h4>
                                                    <p>Inspired by your favourite artists</p>
                                                    <div class="main-border-button">
                                                        <a href="/Tweeling/clothingList.pro">Browse CLOTHING</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <img src="resources/mainView_resources/fashion.jpg">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="right-first-image">
                                        <div class="thumb">
                                            <div class="inner-content">
                                                <h4>BEAUTY</h4>
                                            </div>
                                            <div class="hover-content">
                                                <div class="inner">
                                                    <h4>BEAUTY</h4>
                                                    <p>Oh so pretty...!!</p>
                                                    <div class="main-border-button">
                                                        <a href="/Tweeling/beautyList.pro">Browse BEAUTY</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <img src="resources/mainView_resources/beauty.jpg">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="right-first-image">
                                        <div class="thumb">
                                            <div class="inner-content">
                                                <h4>ACCESSORIES</h4>
                                            </div>
                                            <div class="hover-content">
                                                <div class="inner">
                                                    <h4>ACCESSORIES</h4>
                                                    <p>Everlasting precious</p>
                                                    <div class="main-border-button">
                                                        <a href="/Tweeling/accList.pro">Browse ACCESSORIES</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <img src="resources/mainView_resources/acc.jpg">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="explore">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="left-content">
                            <h2>EXPLORE TWEELING</h2>
                            <p>We offer you very special, ONCE-IN-A-LIFETIME experiences exclusively for you. To
                                check
                                our awesome and iconic events, visit our event page by clicking "EVENT" tab on the
                                navigation bar, or "Check EVENTS" below.</p>
                            <div class="quote">
                                <p>We promise that we will NOT share your personal information.</p>
                            </div>
                            <p>Schedule of events or other policies may be changed if inevitable. We will notice you
                                any
                                changes immediately. It is your responsibility to daily-check our announcements.</p>
                            <p>Visit our Announcements page by clicking "ANNOUNCEMENT" tab on the navigation bar, or
                                "See ANNOUNCEMENTS" below.</p>
                            <div class="main-border-button">
                                <a href="/Tweeling/eventListView.event">Check EVENTS</a>&nbsp;&nbsp;<a href="/Tweeling/list.no">See ANNOUNCEMENTS</a>
                            </div>
                            <br>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="right-content">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="first-image">
                                        <img src="resources/mainView_resources/explore2.jpg">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>