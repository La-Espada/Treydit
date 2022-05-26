export default function authHeader() {
    const treyder = JSON.parse(localStorage.getItem('treyder'));
    if (treyder && user.accessToken) {
      return { Authorization: 'Bearer ' + user.accessToken };
    } else {
      return {};
    }
  }