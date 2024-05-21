import { NavLink } from 'react-router-dom';

const Home = () => {
  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-200" style={{ backgroundImage: `url(https://firebasestorage.googleapis.com/v0/b/gestion-app-uribe.appspot.com/o/fashion-6801626_1280.jpg?alt=media&token=ab2e512a-5110-4aac-bfa8-d471e5697e6a)` }}>
      <div className="max-w-md bg-white p-8 rounded shadow-lg">
        <h1 className="text-3xl font-bold mb-8 text-center">Gestión de Proveedores GCO</h1>
        <div className="grid gap-4">
          <NavLink to="/formulario" className="block bg-blue-800 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline text-center">
            Registrar Proveedor
          </NavLink>
          <NavLink to="/lista" className="block bg-blue-800 hover:bg-green-600 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline text-center">
            Listar Proveedores
          </NavLink>
        </div>
      </div>
    </div>
  );
};

export default Home;