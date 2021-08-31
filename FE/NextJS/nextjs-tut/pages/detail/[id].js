import axios from 'axios'
import Head from 'next/head'
import { useRouter } from 'next/router'
import { useEffect, useState } from 'react'
import { Loader } from 'semantic-ui-react'
import Item from '../../src/component/Item'
/* 
  다이나믹 라우팅으로 만약 클릭을 하게 되면 해당 id에 대한 페이지로 들어오게 됨.
*/
const Post = ({ item, name }) => {
  const router = useRouter();

  if (router.isFallback) {
    return <div style={{ padding: "100px 0" }}>
      <Loader active inline="centered">
        Loading...
      </Loader>
    </div>
  }
  return <>{item && (<>
    <Head>
      <title>{item.name}</title>
      <meta name="description" content={item.description}></meta>
    </Head>
    {name} 환경입니다.
    <Item item={item} /></>)}</>
}

export default Post;

export async function getStaticPaths() {
  // 이제 실제 리스트 API 호출해서 paths를 불러오겠음.
  const apiUrl = process.env.API_URL
  const res = await axios.get(apiUrl);
  const data = res.data
  return {
    // paths: [
    //   { params: { id: '740' } },
    //   { params: { id: '730' } },
    //   { params: { id: '729' } }
    // ],
    paths: data.slice(0, 9).map(item => ({
      params: {
        id: item.id.toString(),
      },
    })),
    fallback: true, // fallback : 없는 페이지에 대한 대응을 할지 안할지 설정.

  };
}

export async function getStaticProps(context) {
  // context : 여러가지 정보, params, 요청,
  const id = context.params.id;
  const apiUrl = `http://makeup-api.herokuapp.com/api/v1/products/${id}.json`
  const res = await axios.get(apiUrl);
  const data = res.data

  return {
    props: {
      item: data,
      name: process.env.name
    }
  }

}