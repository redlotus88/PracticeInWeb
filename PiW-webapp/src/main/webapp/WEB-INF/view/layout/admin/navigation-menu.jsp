<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li>
                <a class="active-menu" href="${ctx}/admin/dashboard" data-selected-links="/admin/dashboard"><i class="fa fa-dashboard"></i> 仪表盘</a>
            </li>
            <li>
                <a href="ui-elements.html"><i class="fa fa-desktop"></i> UI Elements</a>
            </li>
            <li>
                <a href="chart.html"><i class="fa fa-bar-chart-o"></i> Charts</a>
            </li>
            <li>
                <a href="tab-panel.html"><i class="fa fa-qrcode"></i> Tabs & Panels</a>
            </li>
            
            <li>
                <a href="table.html"><i class="fa fa-table"></i> Responsive Tables</a>
            </li>
            <li>
                <a href="form.html"><i class="fa fa-edit"></i> Forms </a>
            </li>

            <li>
                <a href="#" data-selected-links="/settings"><i class="fa fa-gear fa-fw"></i> 设置<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="${ctx}/settings/profile" data-selected-links="/settings/profile"><i class="fa fa-user fa-fw"></i>个人档案</a>
                    </li>
                    <li>
                        <a href="${ctx}/settings/account" data-selected-links="/settings/account"><i class="fa fa-id-card" aria-hidden="true"></i>账号</a>
                    </li>
                    <!-- 3级菜单 -->
                    <!-- <li>
                        <a href="#">Second Level Link<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li>
                                <a href="#">Third Level Link</a>
                            </li>
                            <li>
                                <a href="#">Third Level Link</a>
                            </li>
                            <li>
                                <a href="#">Third Level Link</a>
                            </li>
                        </ul>
                    </li> -->
                </ul>
            </li>
        </ul>

    </div>

</nav>
<!-- /. NAV SIDE  -->