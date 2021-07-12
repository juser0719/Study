import Head from 'next/head'
import Image from 'next/image'
import styles from '../styles/Home.module.css'
import axios from 'axios'
import {useEffect, useState} from 'react'
import ItemList from '../src/component/ItemList'
import { Divider, Header, Loader } from 'semantic-ui-react'

export default function Home({list}) {
  // const API_URL = process.env.NEXT_PUBLIC_API_URL
  // const [list,setList] = useState([]);
  // const [isLoading, setIsLoading] = useState(true);
  // useEffect(() => {
  //   axios.get(API_URL)
  //   .then((res) =>{
  //   setList(res.data)
  //   console.log(res.data)
  //   setIsLoading(false);
  //   })
  // }, [])
  return (
    <div>
      <Head>
        <title>HOME | JUSER</title>
      </Head>
      {/* {
        isLoading && (<div style= {{padding : "300px 0"}}> 
          <Loader inline="centered" active>
            Loading
          </Loader>
        </div>)
      }
      {
        !isLoading &&( */}
          <>
          <Header as ="h3" style={{paddingTop : 40}}>Best Item</Header>
          <Divider />
          <ItemList list = {list.slice(0,9)}/>
          <Header as ="h3" style={{paddingTop : 40}}>New Item</Header>
          <Divider />
          <ItemList list = {list.slice(9)}/>
      </>
        )
      {/* } */}
      
    </div>
  )
}

export async function getStaticProps() {
  // 빌드시에 딱 한번만 호출되고 바로 static file로 빌드됨. = 이후 수정 불가.
  const apiUrl = process.env.API_URL;
  const res = await axios.get(apiUrl);
  const data= res.data

  return {
    props: {
      list : data,
      name : process.env.name
    }
  }
}