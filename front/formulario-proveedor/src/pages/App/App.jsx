import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Home from '../Home/Home.jsx'
import Formulario from "../Formulario/Formulario.jsx";
import Lista from "../Lista/Lista.jsx";
import './App.css'

function App() {
  let router = createBrowserRouter([
    { path: "/", element: <Home /> },
    { path: "/formulario", element: <Formulario /> },
    { path: "/lista", element: <Lista /> }

  ]);

  return (
    <RouterProvider router={router}>
      <Home />
    </RouterProvider>
  );
}



export default App
