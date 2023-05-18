
import Table from '@/components/Table'
import Link from 'next/link'
import { FaEye, FaPlus, FaSearch, FaTrash } from "react-icons/fa"

type VehicleInfo = {
    renavam: string;
    modelo: string;
    placa: string;
    crv: string;
    crlv: string;
    cor: string;
    cpf?: string;
}

type VehicleJSON = {
    renavam: string;
    modelo: string;
    placa: string;
    crv: string;
    crlv: string;
    cor: string;
    cpfMotorista?: {
        cpf: string;
    };
}

export default async function BuscarVeiculo(){

    const all_vehicles:Array<VehicleInfo> = [];
    const elements:Array<React.ReactNode> = [];

    await fetch(`${process.env.API_PATH}/veiculos/listar/todos`, {
        method: 'GET',
        cache: 'no-cache'
    }).then(async (response) => {
        
        const vehicles_json:Array<VehicleJSON> = await response.json();

        if(vehicles_json.length > 0) 
            vehicles_json.forEach((vehicle) => {
                all_vehicles.push({
                    renavam: vehicle.renavam,
                    modelo:  vehicle.modelo,
                    placa:  vehicle.placa,
                    crlv:  vehicle.crlv,
                    crv:  vehicle.crv,
                    cor:  vehicle.cor,
                    cpf: vehicle.cpfMotorista?.cpf
                });
            })
        else elements.push(<tr><td className='td-not-found' colSpan={10}>Nenhum veículo encontrado!</td></tr>)

    }).catch((err) => {
        elements.push(<tr><td className='td-error' colSpan={10}>Ops! Ocorreu um erro ao listar os veículos!</td></tr>)
    });

    all_vehicles.forEach(vehicle => {
        elements.push(
            <tr>
                <td>{vehicle.renavam}</td>
                <td>{vehicle.placa}</td>
                <td>{vehicle.crv}</td>
                <td>{vehicle.crlv }</td>
                <td>{vehicle.modelo ?? <span className='text-red-400'>Não informado!</span>}</td>
                <td>{vehicle.cor ?? <span className='text-red-400'>Não informado!</span>}</td>
                <td>{vehicle.cpf ?? <span className='text-red-400'>Não informado!</span>}</td>
                <td className='flex gap-2'>
                    <Link href={`/admin/veiculo/visualizar/${vehicle.renavam}`}>
                        <button title='Visualizar' className='transition-all rounded p-2 bg-slate-500 text-white hover:bg-slate-400'>
                            <FaEye size={12} /> 
                        </button>
                    </Link>
                    <button title='Deletar' className='transition-all rounded p-2 bg-red-500 text-white hover:bg-red-400'>
                        <FaTrash size={12} /> 
                    </button>
                </td>
            </tr>
        )
    });

    return (
        <Table>
            <thead>
                <tr>
                    <th>Renavam</th>
                    <th>Placa</th>
                    <th>CRV</th>
                    <th>CRLV</th>
                    <th>Modelo</th>
                    <th>Cor</th>
                    <th>Motorista</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                { elements }
            </tbody>
        </Table>
    )

}