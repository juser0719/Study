import '../styles/globals.css'
import 'semantic-ui-css/semantic.min.css'
import Footer from '../src/component/Footer'
import Top from '../src/component/Top';

function MyApp({ Component, pageProps }) {
  // Component : 현재 페이지 의미 , pageProps : 데이터 케치 메서드로 가져온 초기 객체
  return  <div style={{ width: 1000, margin: "0 auto" }}>
  <Top />
  <Component {...pageProps} />
  <Footer/>
  </div>
}

export default MyApp;

/*
client에서 띄우길 바라는 전체 컴포넌트의 레이아웃
최초 실행됨.
페이지 전환시 레이아웃 유지
페이지 전환시 상태값 유지
componentDidCatch 를 이용해서 커슽첨 에러 핸들링 가능
추가적 데이터를 페이지로 주입 가능
글로벌 CSS를 이곳에 선언 
*/
