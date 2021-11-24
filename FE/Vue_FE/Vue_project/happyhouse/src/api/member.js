import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(user, success, fail) {
  await api.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
}

async function findById(userid, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/user/info/${userid}`).then(success).catch(fail);
}

async function register(user, success, fail) {
  await api
    .post(`/user/register`, JSON.stringify(user))
    .then(success)
    .catch(fail);
}

async function updateMember(user, success, fail) {
  await api
    .post(`/user/modify`, JSON.stringify(user))
    .then(success)
    .catch(fail);
}

async function deleteMember(userid, success, fail) {
  await api.get(`/user/delete/${userid}`).then(success).catch(fail);
}

async function idCheck(userid, success, fail) {
  await api.get(`/user/idcheck/${userid}`).then(success).catch(fail);
}

// function logout(success, fail)

export { login, findById, register, deleteMember, idCheck, updateMember };
