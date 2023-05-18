"use client"

import Link from "next/link";
import { useState } from "react";
import { FaPlus, FaSearch } from "react-icons/fa";

type LayoutMotoristaProperties = {
    children: React.ReactNode;
}

export default function LayoutMotorista({ children }:LayoutMotoristaProperties){

    const [search, setSearch] = useState("");

    return(
        <div className="m-1 mx-2 bg-white rounded flex-1 overflow-hidden h-full" style={{maxHeight: 'calc(100vh - 65px)'}}>

            { children }

        </div>
    )

}