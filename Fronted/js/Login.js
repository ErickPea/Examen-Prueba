const form = document.getElementById('loginForm');
const messageDiv = document.getElementById('message');

form.addEventListener('submit', (event) => {
  event.preventDefault(); // Evitar el envío del formulario

  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;

  // Aquí puedes agregar la lógica para validar las credenciales
  // Por ejemplo, comparar con un conjunto de credenciales válidas almacenadas en algún lugar

  if (username === 'admin' && password === 'password') {
    messageDiv.textContent = 'Inicio de sesión exitoso';
    messageDiv.style.color = 'green';
  } else {
    messageDiv.textContent = 'Credenciales inválidas';
    messageDiv.style.color = 'red';
  }
});