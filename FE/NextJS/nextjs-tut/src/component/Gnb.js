import { useRouter } from 'next/router';
import { Menu } from 'semantic-ui-react';

export default function Gnb(){
    let activeItem;
    const router = useRouter()
    const goLink = (e,data) =>{
      if (data.name === 'home'){
        router.push('/')
      }else if (data.name === 'about'){
        router.push('/about')
      }
    }

    if (router.pathname === '/')
      activeItem = "home"
    else if (router.pathname === '/about')
      activeItem = "about"

    return ( <Menu inverted>
        <Menu.Item
          name='home'
          active={activeItem === 'home'}
          onClick = {goLink}
        />
        <Menu.Item
          name='about'
          active={activeItem === 'about'}
          onClick = {goLink}
        />
        <Menu.Item
          name='contact'
          active={activeItem === 'contact'}
          onClick = {goLink}
        />
      </Menu>)
}