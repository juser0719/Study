import Document,{ Html, Head, Main, NextScript } from "next/document";

function MyDocument (){

    return (
      <Html lang="ko">
        <Head />
        <body>
          <Main />
          <NextScript />
        </body>
      </Html>
    );
}
MyDocument.getInitialProps = Document.getInitialProps;
//  각 페이지마다 사전에 불러와야할 데이터를 서버에서 미리 처리하도록 도와줌.

MyDocument.renderDocument = Document.renderDocument;
//  static html를 구성하기 위한 _app.js에서 구성한 Html body가 어떤 형태로 들어갈지 구성
export default MyDocument;

/*
시멘틱 태그를 구성하기 위해 _app.js에서 구성한 html body가 어떤 형태로 들어갈지 구성하는 곳
서버에서만 렌더링되고 onclick 같은 것은 작동 X
그리고 CSS도 작성 X
nextJS 페이지들은 마크업 정의를 건너뛰고 페이지를 만들기 때문에 아래의 HTML을 수정하려 할때 이 파일로 수정 해야함
*/