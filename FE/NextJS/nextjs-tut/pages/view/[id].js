import axios from 'axios'
import { useRouter } from 'next/router'
import {useEffect, useState} from 'react'
import Item from '../../src/component/Item'
/* 
다이나믹 라우팅으로 만약 클릭을 하게 되면 해당 id에 대한 페이지로 들어오게 됨.
 
*/
const Post = () => {
  const [item, setItem] = useState({})
  const router = useRouter()
  const { id } = router.query
  const API_URL = `http://makeup-api.herokuapp.com/api/v1/products/${id}.json`

  useEffect(() => { 
    if (id&& id >0){
      axios.get(API_URL)
    .then(res =>{
      setItem(res.data)
    })
    }
    
    
  }, [id])
  return <Item item ={item}/>
}

export default Post