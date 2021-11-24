import { apiInstance } from "./index.js";

const api = apiInstance();

function sidoList(success, fail) {
  api.get(`/map/sido`).then(success).catch(fail);
}

function gugunList(params, success, fail) {
  api.get(`/map/gugun`, { params: params }).then(success).catch(fail);
}

function dongList(params, success, fail) {
  console.log(params);
  api.get(`/map/dong`, { params: params }).then(success).catch(fail);
}

function houseList(params, success, fail) {
  api.get(`/map/apt`, { params: params }).then(success).catch(fail);
}

function dealList(requestdto, success, fail) {
  console.log("@@@@");
  console.log(JSON.stringify(requestdto));

  api.post(`/map/aptAPI`, JSON.stringify(requestdto)).then(success).catch(fail);
}

export { sidoList, gugunList, houseList, dongList, dealList };
