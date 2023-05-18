
import Table from '@/components/Table'

type SearchVehicleProperties = {
    params?: {renavam?: string};
}

type VehicleInfo = {
    renavam: string;
    modelo: string;
    placa: string;
    crv: string;
    crlv: string;
    cor: string;
    cpf?: string;
}

export default async function BuscarVeiculoPeloRenavam({ params }:SearchVehicleProperties){

    let all_vehicles:Array<VehicleInfo> = [];
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
                <tr>
                    <td>
                    {params?.renavam}
                    </td>
                </tr>
            </tbody>
        </Table>
    )

}