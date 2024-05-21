import { useState, useEffect } from "react";
import axios from 'axios';
import { Link } from 'react-router-dom';

const Lista = () => {
    const [proveedores, setProveedores] = useState([]);

    const consultarProveedores = async () => {
        try {
            let respuesta = await axios.get("http://localhost:8080/proveedorapi/v1/proveedor");
            let respuestaProveedores = respuesta.data;
            setProveedores(respuestaProveedores);
        } catch (error) {
            console.error('Error al consultar proveedores:', error);
        }
    };

    useEffect(() => {
        consultarProveedores();
    }, []);

    return (
        <div className="container mx-auto">
            <h1 className="text-3xl font-bold mb-4">Lista de Proveedores</h1>
            <table className="min-w-full bg-blue-100 border rounded-lg overflow-hidden">
                <thead className="bg-blue-500 text-white">
                    <tr>
                        <th className="px-4 py-2">Razón Social</th>
                        <th className="px-4 py-2">Representante Legal</th>
                        <th className="px-4 py-2">Teléfono</th>
                        <th className="px-4 py-2">Correo Electrónico</th>
                        <th className="px-4 py-2">Dirección</th>
                        <th className="px-4 py-2">Ciudad</th>
                    </tr>
                </thead>
                <tbody>
                    {proveedores.map((proveedor, index) => (
                        <tr key={index} className={index % 2 === 0 ? 'bg-blue-200' : 'bg-blue-100'}>
                            <td className="border px-4 py-2">{proveedor.razonSocial}</td>
                            <td className="border px-4 py-2">{proveedor.nombreRepresentanteLegal}</td>
                            <td className="border px-4 py-2">{proveedor.telefono}</td>
                            <td className="border px-4 py-2">{proveedor.email}</td>
                            <td className="border px-4 py-2">{proveedor.direccion}</td>
                            <td className="border px-4 py-2">{proveedor.ciudad.nombreCiudad}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <div className="flex justify-end mt-4">
                <Link to="/" className="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Volver al Home</Link>
            </div>
        </div>
    );
};

export default Lista;