import { Header } from "semantic-ui-react";
import Gnb from "./Gnb";

export default function Top() {
  return (
    <div>
      <div style={{ display: "flex", paddingTop: 20 }}>
        <div style={{ flex: "100px 0 0" }}>
          <img
            src="https://cdn.loud.kr/prod/public/thumb/order_sub_1993492_1_170621201736.jpg"
            alt="logo"
            style={{ display: "block", width: 80 }}
          />
        </div>
        <Header as="h1">J-USER</Header>
      </div>
      <Gnb />
    </div>
  );
}