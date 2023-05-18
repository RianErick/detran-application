"use client"

import Link from "next/link";
import { useState } from "react";
import { FaPlus, FaSearch } from "react-icons/fa";

type LayoutCadastrarMotoristaProperties = {
    children: React.ReactNode;
}

export default function LayoutCadastrarMotorista({ children }:LayoutCadastrarMotoristaProperties){

    const [search, setSearch] = useState("");

    return(
        <div className="m-1 mx-2 p-4 bg-white rounded flex-1 overflow-hidden h-full" style={{maxHeight: 'calc(100vh - 65px)'}}>

            <div className="flex gap-2">
                <div className="flex flex-1">
                    <input onInput={(e:any) => setSearch(e.target.value)} className="transition-all w-full text-sm border p-2 outline-none focus:ring-blue-200 focus:ring" placeholder="Insira o RENAVAM do veículo..." style={{borderRadius: '0.2em 0 0 0.2em'}}/>
                    
                    <Link href={`/admin/veiculo/buscar/${search}`} >
                        <button className="transition-all flex items-center justify-between gap-2 text-white p-2 px-5 bg-blue-400 hover:bg-blue-300 focus:ring-blue-200 focus:ring" style={{borderRadius: '0 0.2em 0.2em 0'}}>
                            <FaSearch className="text-white" size={16}/> Buscar 
                        </button>
                    </Link>
                </div>
                <Link href="/admin/veiculo/cadastrar" >
                    <button className="transition-all rounded flex items-center justify-between gap-2 text-white p-2 px-5 bg-emerald-400 hover:bg-emerald-300 focus:ring-emerald-200 focus:ring">
                        <FaPlus />
                        Cadastrar
                    </button>
                </Link>
            </div>

            <hr className="my-2" />

            { children }

        </div>
    )

}