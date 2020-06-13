<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

html,
body,
head,
style {
  &,
  &::after,
  &::before {
    content: "";
    box-sizing: border-box;
    margin: 0;
    padding: 0;
    display: block;
    height: 0;
  }
}

%center {
  position: absolute;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  margin: auto;
}

:root {
  --main-color-hue: 217;
  --main-color: hsla(var(--main-color-hue), 97%, 61%, 1);
  --black: #222;
  --red: #ed6b5f;
}

// eyes
style {
  overflow: hidden;
  color: transparent;
  line-height: 0;
  width: 5.1rem;
  height: 2rem;
  margin-top: 0.2rem;
  @extend %center;

  &::before {
    width: 0.3rem;
    height: 0.3rem;
    background: var(--black);
    margin-top: 1.6rem;
    margin-left: 1.6rem;
    border-radius: 50%;
    box-shadow: 0 0 0 0.3rem white, 1.4rem -0.2rem 0 var(--black),
      1.5rem 0 0 0.3rem white;
  }
}

head {
  width: 5.1rem;
  height: 5.1rem;
  background: var(--main-color);
  border-radius: 50%;
  margin: auto;
  z-index: -1;
  box-shadow: 0 0 0 2rem hsla(var(--main-color-hue), 97%, 61%, 0.1),
    0 0 0 4rem hsla(var(--main-color-hue), 97%, 61%, 0.05),
    0 0 0 6rem hsla(var(--main-color-hue), 97%, 61%, 0.025);
  @extend %center;

  // mouth
  &::after {
    background: #222;
    border-radius: 4rem 4rem 0.5rem 0.5rem;
    width: 1.1rem;
    height: 0.5rem;
    background: var(--red);
    margin-bottom: 1.2rem;
    box-shadow: 0 -0.3rem 0 0.3rem var(--black);
    @extend %center;
  }
}

html {
  background: #f9f9f9;
  font-family: system-ui, Helvetica, Roboto, sans-serif;
  text-align: center;

  &::after {
    line-height: 0;
    height: 0;
    transform: translatex(1rem);
    content: "4 4";
    font-size: 7rem;
    color: #3c86fc;
    letter-spacing: 2rem;
    font-weight: bold;
    @extend %center;
  }

  &::before {
    content: "You seem lost.";
    font-family: "Merriweather", serif;
    color: var(--main-color);
    font-weight: bolder;
    line-height: 0;
    height: 0;
    @extend %center;
    transform: translatey(11rem);
    font-size: 2rem;
  }
}

body {
  width: 100vw;
  height: 100vh;
  overflow-x: hidden;

  &::after {
    content: "The page you are trying to reach doesn't exist.";
    font-family: "Merriweather Sans", sans-serif;
    color: var(--black);
    font-size: 1rem;
    line-height: 0;
    height: 0;
    transform: translatey(14rem);
    @extend %center;
  }
}

</style>
</head>
<body>
	Error !
	<h1>404</h1>
	<h2>Not Found</h2>
</body>
</html>