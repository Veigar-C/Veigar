<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@declare id="questel"--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link rel="stylesheet" href="css/jquery.mobile.min.css">
    <script src="js/jquery-1.6.4.min.js"></script>
    <script src="js/jquery.mobile.min.js"></script>
    <script src="js/dL_fromPhonePage.js"></script>
</head>
<body>
<div data-role="page" id="pageone">
    <div data-role="header">
        <h1>违章信息查询</h1>
    </div>

    <div data-role="content">
        <label>carNum:${param.carNum}</label>
        <form>
            <c:forEach items="${requestScope.violationRecord}" var="dl">
            <ul data-role="listview" data-inset="true">
                <li data-role="fieldcontain">
                    <div class="ui-grid-a">
                        <div class="ui-block-a">
                            <label style="display: none" id="code">${dl.code}</label>
                            <label for="quesTel">办理标志:${dl.vState}</label>
                        </div>
                        <div class="ui-block-b">
                            <label for="quesTel">罚款金额:${dl.vMoney}元</label>
                        </div>
                    </div>
                </li>
                <li data-role="fieldcontain">
                    <div class="ui-grid-a">
                        <div class="ui-block-a">
                            <label for="quesTel">扣分数:${dl.vPoints}分</label>
                        </div>
                        <div class="ui-block-b">
                            <label for="quesTel">服务费:${dl.vSMoney}元</label>
                        </div>
                    </div>
                </li>

                <li data-role="fieldcontain">
                    <div class="ui-grid-a">
                        <div class="ui-block-a">
                            <label for="quesTel">违章行为:</label>
                        </div>
                        <div class="ui-block-b">
                            <label for="quesTel">${dl.vContent}</label>
                        </div>
                    </div>
                    <div class="ui-grid-a">
                        <div class="ui-block-a">
                            <label for="quesTel">违章时间:</label>
                        </div>
                        <div class="ui-block-b">
                            <label for="quesTel">${dl.vDate}</label>
                        </div>
                    </div>
                    <div class="ui-grid-a">
                        <div class="ui-block-a">
                            <label for="quesTel">违章地点:</label>
                        </div>
                        <div class="ui-block-b">
                            <label for="quesTel">${dl.vAddress}</label>
                        </div>
                    </div>
                </li>
                <li data-role="fieldcontain">
                    <div class="ui-grid-a">
                        <div class="ui-block-a">
                            <label >选择</label>
                        </div>
                        <div class="ui-block-b">
                            <input type="checkbox" id="select" name="select" value="${dl.code}">
                        </div>
                    </div>
                </li>
            </ul>
            </c:forEach>
            <li data-role="fieldcontain">
                <input type="submit" value="办理" data-theme="b" onclick="check()" />
                <input type="submit" value="申诉" data-theme="b" onclick="complain()" />
            </li>
        </form>
    </div>

    <div data-role="footer">
        <div data-role="footer">
            <h1>请按行驶证上的信息输入</h1>
        </div>
    </div>
</div>
</body>

</html>
