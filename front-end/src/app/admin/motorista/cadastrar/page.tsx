import MyInput from "@/components/basic/MyInput";
import { FaUser } from "react-icons/fa";

export default async function CadastrarMotorista(){

    return (
        <div className="p-4">
            <h1 className="text-slate-400 text-sm flex gap-2 place-items-center"><FaUser size={24}/> Cadastrar Novo Motorista</h1>

            <div className="p-4 flex bg-blue-50 mt-4 gap-2">
                <MyInput id="cpf" maxLength={14} label="CPF" placeholder="000.000.000-00" type="cpf"/>
                <MyInput id="email" label="Email" placeholder="exemplo@email.com" type="email"/>
                <MyInput id="nome" label="Nome Completo" placeholder="Nome Completo" type="text"/>
            </div>

        </div>
    )

}