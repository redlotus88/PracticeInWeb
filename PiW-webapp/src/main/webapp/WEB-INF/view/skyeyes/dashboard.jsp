<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <script src="http://echarts.baidu.com/dist/echarts.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/core.js"></script>
</head>

<div class="row">
    <div class="col-md-12">
        <h1 class="page-header">
            天眼项目 仪表盘 <small> Dashboard</small>
        </h1>
    </div>
</div>
<!-- /. ROW  -->

<div class="row">
    <div class="col-md-3 col-sm-12 col-xs-12">
        <div class="panel panel-primary text-center no-boder bg-color-green">
            <div class="panel-body">
                <i class="fa fa-bar-chart-o fa-5x"></i>
                <h3>${dailyVisits}</h3>
            </div>
            <div class="panel-footer back-footer-green">
                Daily Visits
            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-12 col-xs-12">
        <div class="panel panel-primary text-center no-boder bg-color-blue">
            <div class="panel-body">
                <i class="fa fa-shopping-cart fa-5x"></i>
                <h3>52,160 </h3>
            </div>
            <div class="panel-footer back-footer-blue">
                Sales

            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-12 col-xs-12">
        <div class="panel panel-primary text-center no-boder bg-color-red">
            <div class="panel-body">
                <i class="fa fa fa-comments fa-5x"></i>
                <h3>15,823 </h3>
            </div>
            <div class="panel-footer back-footer-red">
                Comments

            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-12 col-xs-12">
        <div class="panel panel-primary text-center no-boder bg-color-brown">
            <div class="panel-body">
                <i class="fa fa-users fa-5x"></i>
                <h3>36,752 </h3>
            </div>
            <div class="panel-footer back-footer-brown">
                No. of Visits

            </div>
        </div>
    </div>
</div>


<div class="row">


    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="panel panel-default">
            
            <div class="panel-heading">
                每日车辆入库统计
            </div>
            <div class="panel-body">
                 <div id="veh_daily" style="width: 600px; height:400px;"></div>
            </div>
        </div>
    </div>
</div>
<!-- /. ROW  -->

<div class="row">
    <div class="col-md-4 col-sm-12 col-xs-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Tasks Panel
            </div>
            <div class="panel-body">
                <div class="list-group">

                    <a href="#" class="list-group-item">
                        <span class="badge">7 minutes ago</span>
                        <i class="fa fa-fw fa-comment"></i> Commented on a post
                    </a>
                    <a href="#" class="list-group-item">
                        <span class="badge">16 minutes ago</span>
                        <i class="fa fa-fw fa-truck"></i> Order 392 shipped
                    </a>
                    <a href="#" class="list-group-item">
                        <span class="badge">36 minutes ago</span>
                        <i class="fa fa-fw fa-globe"></i> Invoice 653 has paid
                    </a>
                    <a href="#" class="list-group-item">
                        <span class="badge">1 hour ago</span>
                        <i class="fa fa-fw fa-user"></i> A new user has been added
                    </a>
                    <a href="#" class="list-group-item">
                        <span class="badge">1.23 hour ago</span>
                        <i class="fa fa-fw fa-user"></i> A new user has added
                    </a>
                    <a href="#" class="list-group-item">
                        <span class="badge">yesterday</span>
                        <i class="fa fa-fw fa-globe"></i> Saved the world
                    </a>
                </div>
                <div class="text-right">
                    <a href="#">More Tasks <i class="fa fa-arrow-circle-right"></i></a>
                </div>
            </div>
        </div>

    </div>
    <div class="col-md-8 col-sm-12 col-xs-12">

        <div class="panel panel-default">
            <div class="panel-heading">
                Responsive Table Example
            </div> 
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>S No.</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>User Name</th>
                                <th>Email ID.</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>John</td>
                                <td>Doe</td>
                                <td>John15482</td>
                                <td>name@site.com</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Kimsila</td>
                                <td>Marriye</td>
                                <td>Kim1425</td>
                                <td>name@site.com</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>Rossye</td>
                                <td>Nermal</td>
                                <td>Rossy1245</td>
                                <td>name@site.com</td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>Richard</td>
                                <td>Orieal</td>
                                <td>Rich5685</td>
                                <td>name@site.com</td>
                            </tr>
                            <tr>
                                <td>5</td>
                                <td>Jacob</td>
                                <td>Hielsar</td>
                                <td>Jac4587</td>
                                <td>name@site.com</td>
                            </tr>
                            <tr>
                                <td>6</td>
                                <td>Wrapel</td>
                                <td>Dere</td>
                                <td>Wrap4585</td>
                                <td>name@site.com</td>
                            </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- /. ROW  -->

<script type="text/javascript">
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init($('div#veh_daily'));

	// 指定图表的配置项和数据
	var option = {
		title : {
			text : 'ECharts 入门示例'
		},
		tooltip : {},
		legend : {
			data : [ '销量' ]
		},
		xAxis : {
			data : [ "衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子" ]
		},
		yAxis : {},
		series : [ {
			name : '销量',
			type : 'bar',
			data : [ 5, 20, 36, 10, 10, 20 ]
		} ]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
</script>
