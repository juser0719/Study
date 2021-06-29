import { useRouter } from 'next/router'
/* 
다이나믹 라우팅으로 만약 클릭을 하게 되면 해당 id에 대한 페이지로 들어오게 됨.
 
*/
const Post = () => {
  const router = useRouter()
  const { id } = router.query

  return <p>Post: {id}</p>
}

export default Post