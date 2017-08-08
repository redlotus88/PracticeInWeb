<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li>
                <a href="${ctx}/admin/dashboard" data-selected-link="/admin/dashboard"><i class="fa fa-dashboard"></i> 仪表盘</a>
            </li>
            <li>
                <a href="#" data-selected-link="/admin/mgr" aria-expanded="false"><i class="fa fa-desktop"></i>全局管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="${ctx}/admin/mgr/account" data-selected-link="/admin/mgr/account"><i class="fa fa-user fa-fw"></i> 账号权限管理</a>
                    </li>
                    <li>
                        <a href="${ctx}/admin/mgr/role" data-selected-link="/admin/mgr/role"><i class="fa fa-id-card" ></i> 权限角色管理</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#" data-selected-link="/admin/git" aria-expanded="false"><i class="fa fa-github"></i> Git<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="${ctx}/admin/git/repository" data-selected-link="/admin/git/repository"><i class="fa fa-user fa-fw"></i> Git远程仓库管理</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-qrcode"></i> Tabs & Panels</a>
            </li>
            
            <li>
                <a href="#"><i class="fa fa-table"></i> Responsive Tables</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-edit"></i> Forms </a>
            </li>

            <li>    
                <a href="#" data-selected-link="/settings" aria-expanded="false"><i class="fa fa-gear fa-fw"></i> 设置<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="${ctx}/settings/profile"
                            data-selected-link="/settings/profile"><i class="fa fa-user fa-fw"></i>个人档案</a>
                    </li>
                    <li>
                        <a href="${ctx}/settings/account"
                         data-selected-link="/settings/account"><i class="fa fa-id-card" aria-hidden="true"></i>账号</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
<!-- /. NAV SIDE  -->