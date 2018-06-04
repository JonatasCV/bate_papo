<%-- 
    Document   : login
    Created on : May 29, 2018, 1:11:08 PM
    Author     : Gabriel Consalter
--%>

<%@include file="/WEB-INF/shared/header.jsp" %>

<div class="ui middle aligned center aligned grid animated fadeInDown">
  <div class="column" id="boxLogin">
    <h2 class="ui primary image header">
      <div class="content">
        BatePapoApp
      </div>
    </h2>
    <form class="ui large form">
      <div class="ui segment">
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="email" placeholder="E-mail address" autofocus>
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" name="password" placeholder="Password">
          </div>
        </div>
        <div class="ui fluid large primary submit button">Entrar</div>
      </div>

      <div class="ui error message"></div>

    </form>
  </div>
</div>

<%@include file="/WEB-INF/shared/footer.jsp" %>