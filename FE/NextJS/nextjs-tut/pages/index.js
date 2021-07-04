import Head from 'next/head'
import Image from 'next/image'
import styles from '../styles/Home.module.css'
import axios from 'axios'
import {useEffect, useState} from 'react'
import ItemList from '../src/component/ItemList'
import { Divider, Header, Loader } from 'semantic-ui-react'

export default function Home() {
  const API_URL = "http://makeup-api.herokuapp.com/api/v1/products.json?brand=maybelline"
  const [list,setList] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  useEffect(() => {
    axios.get(API_URL)
    .then((res) =>{
    setList(res.data)
    console.log(res.data)
    setIsLoading(false);
    })
  }, [])
  return (
    <div>
      <Head>
        <title>HOME | JUSER</title>
      </Head>
      {
        isLoading && (<div style= {{padding : "300px 0"}}> 
          <Loader inline="centered" active>
            Loading
          </Loader>
        </div>)
      }
      {
        !isLoading &&(
          <>
          <Header as ="h3" style={{paddingTop : 40}}>Best Item</Header>
          <Divider />
          <ItemList list = {list.slice(0,9)}/>
          <Header as ="h3" style={{paddingTop : 40}}>New Item</Header>
          <Divider />
          <ItemList list = {list.slice(9)}/>
      </>
        )
      }
      
    </div>
  )
}
