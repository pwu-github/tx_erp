<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp" %>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			$("#pageNo").val(1);
			$("#queryEmpForm").submit();
		});
	});
	
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">员工管理</span>
		</div>
	</div>
	<div class="content-text">
		<form id="queryEmpForm" action="${path }/emp_list" method="post">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td height="30">用&nbsp;户&nbsp;名</td>
						<td>
							<s:textfield name="query.username" type="text" size="14"></s:textfield>
						</td>
						<td>真实姓名</td>
						<td><s:textfield name="query.name" type="text" size="14"></s:textfield></td>
						<td>电&nbsp;&nbsp;&nbsp;&nbsp;话</td>
						<td><s:textfield name="query.tel" type="text" size="14"></s:textfield></td>
						<td>性&nbsp;&nbsp;&nbsp;&nbsp;别</td>
						<td>
							<!-- <select class="kuan">
								<option value="-1">----请-选-择----</option>
								<option value="1">男</option>
								<option value="0">女</option>
							</select> -->
							<s:select list="#{'1':'男','2':'女' }" name="query.gender" cssClass="kuan" headerKey="" headerValue="----请-选-择----"></s:select>
						</td>
							
						<td width="70"><a href="input.jsp"> <img src="${path}/images/can_b_02.gif" border="0" /> </a></td>
					</tr>
					<tr>
						<td  height="30">电子邮件</td>
						<td><s:textfield name="query.email" type="text" size="14"></s:textfield></td>
						<td>出生日期</td>
						<td>
							<s:textfield name="query.startBirth" type="text" size="14" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"></s:textfield>
						</td>
						<td>出生日期</td>
						<td>
							<s:textfield name="query.endBirth" type="text" size="14" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"></s:textfield>
						</td>
						<td>部门名称</td>
						<td>
							<!-- 
								使用struts的select标签从后台的数据库的数据来查询展示
								list：取Action中传递来的集合
								cssClass：样式
								name：用于后端接收
								headerKey：空选项的value
								headerValue：空选项的文本
								listKey：选项的value从集合中的一个属性
								listValue：选项的文本从集合中的实体类中的一个属性来取
							 -->
							<s:select list="#dList" cssClass="kuan" name="query.depId" headerKey="" headerValue="----请-选-择----" listKey="depId" listValue="name"></s:select>
						</td>
						<td><a id="query"> <img src="${path}/images/can_b_01.gif" border="0" /> </a></td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(${path}/images/table_bg.gif) repeat-x;">
						<td width="10%" height="30">用户名</td>
						<td width="10%">真实姓名</td>
						<td width="5%">性别</td>
						<td width="12%">出生日期</td>
						<td width="10%">电话</td>
						<td width="12%">电子邮件</td>
						<td width="9%">所属部门</td>
						<td width="16%">操作</td>
					</tr>
					<s:iterator value="#empList" var="emp">
						<tr align="center" bgcolor="#FFFFFF">
							<td width="13%" height="30"><s:property value="#emp.username"/></td>
							<td><s:property value="#emp.name"/></td>
							<td><s:property value="#emp.gender==1?'男':'女'"/></td>
							<td><s:date name="#emp.birthday" format="yyyy-MM-dd"/></td>
							<td><s:property value="#emp.tel"/></td>
							<td><s:property value="#emp.email"/></td>
							<td><s:property value="#emp.dep.name"/></td>
							<td>
								<img src="${path}/images/icon_3.gif" /> 
								<span style="line-height:12px; text-align:center;"> 
									<a href="./input.jsp" class="xiu">修改</a>
								</span> 
								<img src="${path}/images/icon_04.gif" /> 
								<span style="line-height:12px; text-align:center;"> 
									<a href="javascript:void(0)" class="xiu" onclick="showMsg('是否删除该项数据？',318)">删除</a>
								</span>
							</td>
						</tr>
					</s:iterator>
					
				</table>
				<%--<%@ include file="../tools/paging.jsp" %>--%>
			</div>
		</form>
	</div>
	<div class="content-bbg"></div>
</div>
