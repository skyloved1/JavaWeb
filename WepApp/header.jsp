<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
    <div class="container">
        <nav class="navbar navbar-default" role="navigation">
            <!--navbar-header-->
            <div class="collapse navbar-collapse"
                 id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/index" >首页</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle "
                           data-toggle="dropdown">商品分类
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu multi-column columns-2">
                            <li>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <h4>商品分类</h4>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li><a href="#" >热销</a></li>
                    <li><a href="#" >新品</a></li>
                    <li><a href="#" class="active">注册</a></li>
                    <li><a href="#" >登录</a></li>
                </ul>
                <!--/.navbar-collapse-->
            </div>
            <!--//navbar-header-->
        </nav>
        <div class="header-info">
            <div class="header-right search-box">
                <a href="javascript:;">
                    <span class="glyphicon glyphicon-search"
                          aria-hidden="true"></span>
                </a>
                <div class="search">
                    <form class="navbar-form" action="/">
                        <input type="text" class="form-control"
                               name="keyword">
                        <button type="submit" class="btn btn-default"
                                aria-label="Left Align">搜索
                        </button>
                    </form>
                </div>
            </div>
            <div class="header-right cart">
                <a href="goods_cart.jsp">
                    <span class="glyphicon glyphicon-shopping-cart "
                          aria-hidden="true">
                        <span class="card_num"></span>
                    </span>
                </a>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>

