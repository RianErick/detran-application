import DropdownMenu from "@/components/DropdownMenu"
import IconButton from "@/components/IconButton";
import LinkButton from "@/components/LinkButton";
import { FaUser, FaCar, FaHome, FaWrench, FaSignOutAlt, FaGavel, FaReceipt } from "react-icons/fa";

type LayoutProperties = {
    children: React.ReactNode;
}

export default function AdminPageLayout({ children }:LayoutProperties){

    return (
        <div className="flex">

            <div className="h-screen flex flex-col bg-gray-100">
                <div className="bg-white flex justify-evenly px-8 py-2 gap-3 place-items-center shadow-lg h-16">
                    <img src="https://ionicframework.com/docs/img/demos/avatar.svg" className="w-12 h-12 rounded-full" alt="user-icon" />
                    <div className="user-info flex flex-col">
                        <span className="text-sm text-gray-900 font-semibold">John Doe</span>
                        <span className="text-sm text-gray-700">Administração</span>
                    </div>
                </div>

                <div className="flex flex-col justify-between flex-1">
                    <div>
                        <IconButton href="/admin" icon={ <FaHome size={18} /> } title="Home" />

                        <DropdownMenu title="Motoristas" icon={<FaUser size={18} />}>
                            <LinkButton href="/admin/motorista/buscar" title="Buscar" />
                            <LinkButton href="/admin/motorista/cadastrar" title="Cadastrar" />
                        </DropdownMenu>

                        <DropdownMenu title="Veículos" icon={<FaCar size={18} />}>
                            <LinkButton href="/admin/veiculo/buscar" title="Buscar" />
                            <LinkButton href="/admin/veiculo/cadastrar" title="Cadastrar" />
                        </DropdownMenu>

                        <IconButton href="/admin/multas" icon={ <FaReceipt size={18} /> } title="Multas" />
                        <IconButton href="/admin/leilao" icon={ <FaGavel size={18} /> } title="Leitão" />
                    </div>
                    <div className="bg-white shadow-inner py-4">
                        <IconButton href="/admin/configuracoes" color="blue" icon={ <FaWrench size={18} className="text-gray-900" /> } title="Configurações" />
                        <IconButton href="/admin/logout" color="red" icon={ <FaSignOutAlt size={18} className="text-red-600" /> } title="Sair" />
                    </div>
                </div>
                
            </div>

            <div className="flex flex-col w-full bg-gray-300">
                <div className="bg-gray-600 h-16 w-full shadow-xl"></div>

                <div className="w-full h-full flex flex-col">
                    {children}
                </div>
            </div>

        </div>
    )
}