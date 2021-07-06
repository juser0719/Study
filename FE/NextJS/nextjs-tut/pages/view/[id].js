import axios from 'axios'
import Head from 'next/head'
import { useRouter } from 'next/router'
import {useEffect, useState} from 'react'
import { Loader } from 'semantic-ui-react'
import Item from '../../src/component/Item'
/* 
  다이나믹 라우팅으로 만약 클릭을 하게 되면 해당 id에 대한 페이지로 들어오게 됨.
*/
const Post = ({item}) => {
  return <>{ item && (<>
  <Head>
    <title>{item.name}</title>
    <meta name = "description" content ={item.description}></meta>
  </Head>
  <Item item ={item}/></>)}</>
}

export default Post;


export async function getServerSideProps(context) {
  // context : 여러가지 정보, params, 요청,
  const id = context.params.id;
  const apiUrl = `http://makeup-api.herokuapp.com/api/v1/products/${id}.json`
  const res = await axios.get(apiUrl);
  const data= res.data

  return {
    props: {
      item : data
    }
  }

}