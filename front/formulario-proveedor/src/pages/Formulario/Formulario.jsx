import { useContext, useState, useEffect } from "react"
import { NavLink, useNavigate } from 'react-router-dom';
import axios from 'axios'
import Swal from 'sweetalert2'


const Formulario = () => {
    let redireccion = useNavigate()
    const [tipoPersona, setTipoPersona] = useState('');
    const [nit, setNit] = useState('');
    const [razonSocial, setRazonSocial] = useState('');
    const [nombreRepresentante, setNombreRepresentante] = useState('');
    const [telefono, setTelefono] = useState('');
    const [correo, setCorreo] = useState('');
    const [direccion, setDireccion] = useState('');
    const [rutaRut, setRutaRut] = useState(null);
    const [pais, setPais] = useState('');
    const [departamento, setDepartamento] = useState('');
    const [departamentoId, setDepartamentoId] = useState('');
    const [ciudad, setCiudad] = useState('');
    const [ciudadId, setCiudadId] = useState('');
    const [paises, setPaises] = useState([]);
    const [departamentos, setDepartamentos] = useState([]);
    const [ciudades, setCiudades] = useState([]);

    const handleDepartamentoChange = (e) => {
        const selectedDepartamento = departamentos.find(dep => dep.nombreDepartamento === e.target.value);
        if (selectedDepartamento) {
            setDepartamento(selectedDepartamento.nombreDepartamento);
            setDepartamentoId(selectedDepartamento.idDepartamento);
            setCiudad(''); // Resetea la ciudad seleccionada al cambiar de departamento
        }
    };
    const handleCiudadChange = (e) => {
        const selectedCiudad = ciudades.find(ciu => ciu.nombreCiudad === e.target.value);
        if (selectedCiudad) {
            setCiudad(selectedCiudad.nombreCiudad);
            setCiudadId(selectedCiudad.idCiudad);


        }
    };


    const consultarPais = async () => {
        let respuesta = await axios.get("http://localhost:8080/proveedorapi/v1/pais");
        let respuestaPaises = respuesta.data
        setPaises(respuestaPaises)

    }
    const consultarDepartamento = async () => {
        let respuesta = await axios.get("http://localhost:8080/proveedorapi/v1/departamento");
        let respuestaDepartamentos = respuesta.data
        setDepartamentos(respuestaDepartamentos)

    }
    const consultarCiudad = async () => {
        let respuesta = await axios.get("http://localhost:8080/proveedorapi/v1/ciudad");
        let respuestaCiudades = respuesta.data
        setCiudades(respuestaCiudades)

    }
    useEffect(() => {
        consultarPais()
        consultarDepartamento()
        consultarCiudad()

    }, [])
    useEffect(() => {
    }, [paises]);
    useEffect(() => {
    }, [departamentos]);
    useEffect(() => {
    }, [ciudades]);


    const handleSubmit = async () => {
        try {
            // Verificar si todos los campos están llenos
            if (tipoPersona && nit && razonSocial && nombreRepresentante && telefono &&
                direccion && rutaRut && pais && departamento && ciudad && correo) {

                // Crear un FormData object para enviar archivos
                const formData = new FormData();

                // Añadir los datos del proveedor al FormData
                const proveedor = {
                    tipoPersona: tipoPersona,
                    nit: nit,
                    razonSocial: razonSocial,
                    nombreRepresentanteLegal: nombreRepresentante,
                    telefono: telefono,
                    email: correo,
                    pais: {
                        idPais: 1
                    },
                    departamento: {
                        idDepartamento: departamentoId
                    },
                    ciudad: {
                        idCiudad: ciudadId
                    },
                    direccion: direccion,
                    rutaRut: '' // Este campo se puede dejar vacío porque será actualizado en el backend
                };

                // Convertir el objeto a JSON y añadirlo al FormData
                formData.append("proveedor", new Blob([JSON.stringify(proveedor)], { type: "application/json" }));

                // Añadir el archivo al FormData
                formData.append("rut", rutaRut);

                // Realizar la solicitud POST a la API
                const response = await axios.post('http://localhost:8080/proveedorapi/v1/proveedor/registro', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                });

                // Mostrar mensaje de éxito
                if (response.status === 201) {
                    Swal.fire({
                        icon: 'success',
                        title: 'Registro exitoso',
                        text: 'Usuario registrado correctamente.'
                    });
                    setTipoPersona('');
                    setNit('');
                    setRazonSocial('');
                    setNombreRepresentante('');
                    setTelefono('');
                    setCorreo('');
                    setDireccion('');
                    setRutaRut(null);
                    

                    redireccion('/');
                }
            } else {
                // Mostrar mensaje de error si algún campo está vacío
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text: 'Por favor, complete todos los campos.'
                });
            }
        } catch (error) {
            // Mostrar mensaje de error si hay algún problema con la solicitud
            console.error('Error al registrar usuario:', error);
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'Ocurrió un error al registrar el usuario. Por favor, inténtalo de nuevo más tarde.'
            });
        }
    };

    return (
        <div className="flex items-center justify-center min-h-screen bg-gray-200 border bg-cover bg-fixed" style={{ backgroundImage: `url(https://firebasestorage.googleapis.com/v0/b/gestion-app-uribe.appspot.com/o/woman-5828786_1920.jpg?alt=media&token=021910c4-8ea3-4b8d-a866-06ce1d87d250)` }}>
            <form className="w-full max-w-2xl bg-white rounded p-8 shadow-xl border mt-16">
                <h1 className="text-3xl text-center font-bold mb-8">Registro de Proveedores GCO</h1>
                <div className="grid grid-cols-2 gap-4">
                    <div>
                        <div className="mb-4">
                            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="tipoPersona">
                                Tipo de Persona
                            </label>
                            <select id="tipoPersona" name="tipoPersona" className="border py-2 px-3 text-grey-darkest w-full" onChange={(e) => setTipoPersona(e.target.value)}>
                                <option value="">Seleccione...</option>
                                <option value="natural">Natural</option>
                                <option value="juridica">Jurídica</option>
                            </select>
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="nit">
                                NIT O CÉDULA
                            </label>
                            <input id="nit" name="nit" className="border py-2 px-3 text-grey-darkest w-full" type="text" onChange={(e) => setNit(e.target.value)} />
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="razonSocial">
                                Razón Social
                            </label>
                            <input id="razonSocial" name="razonSocial" className="border py-2 px-3 text-grey-darkest w-full" type="text" onChange={(e) => setRazonSocial(e.target.value)} />
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="nombreRepresentanteLegal">
                                Nombre del Representante Legal
                            </label>
                            <input id="nombreRepresentanteLegal" name="nombreRepresentanteLegal" className="border py-2 px-3 text-grey-darkest w-full" type="text" onChange={(e) => setNombreRepresentante(e.target.value)} />
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="telefono">
                                Teléfono
                            </label>
                            <input id="telefono" name="telefono" className="border py-2 px-3 text-grey-darkest w-full" type="text" onChange={(e) => setTelefono(e.target.value)} />
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="email">
                                Correo Electrónico
                            </label>
                            <input id="email" name="email" className="border py-2 px-3 text-grey-darkest w-full" type="text" onChange={(e) => setCorreo(e.target.value)} />
                        </div>
                    </div>
                    <div>
                        <div className="mb-4">
                            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="direccion">
                                Dirección
                            </label>
                            <input id="direccion" name="direccion" className="border py-2 px-3 text-grey-darkest w-full" type="text" onChange={(e) => setDireccion(e.target.value)} />
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="rutaRut">
                                Ruta RUT (Adjuntar archivo)
                            </label>
                            <input id="rutaRut" name="rutaRut" className="border py-2 px-3 text-grey-darkest w-full" type="file" accept=".pdf,.doc,.docx" onChange={(e) => setRutaRut(e.target.files[0])} />
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="pais">
                                País
                            </label>
                            <select id="pais" name="pais" className="border py-2 px-3 text-grey-darkest w-full" onChange={(e) => setPais(e.target.value)}>
                                <option value="">Seleccione...</option>
                                {paises.map((pais, index) => (
                                    <option key={index} value={pais.nombrePais}>{pais.nombrePais}</option>
                                ))}
                            </select>
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="pais">
                                Departamento
                            </label>
                            <select id="pais" name="pais" className="border py-2 px-3 text-grey-darkest w-full" onChange={handleDepartamentoChange}>
                                <option value="">Seleccione...</option>
                                {departamentos.map((departamento, index) => (
                                    <option key={index} value={departamento.nombreDepartamento}>{departamento.nombreDepartamento}</option>
                                ))}
                            </select>
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="ciudad">
                                Ciudad
                            </label>
                            <select id="ciudad" name="ciudad" className="border py-2 px-3 text-grey-darkest w-full" onChange={handleCiudadChange}>
                                <option value="">Seleccione...</option>
                                {departamentos.map((departamentoIterar, index) => (
                                    departamentoIterar.nombreDepartamento === departamento ? (
                                        departamentoIterar.ciudades.map((ciudad, index) => (
                                            <option key={index} value={ciudad.nombreCiudad}>{ciudad.nombreCiudad}</option>
                                        ))
                                    ) : null
                                ))}
                            </select>
                        </div>
                    </div>
                </div>
                <div className="text-center mt-4">
                    <button className="bg-black hover:bg-white hover:text-black text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="button" id="botonRegistro" onClick={handleSubmit}>
                        Registrar
                    </button>
                    <NavLink to="/" className="block mt-2 text-sm text-gray-600 underline">Volver al home</NavLink>
                </div>
            </form>
        </div>
    );
};

export default Formulario;
