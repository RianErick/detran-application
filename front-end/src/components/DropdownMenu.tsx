"use client"
import styles from './styles/Input.module.css'
import { FaUser, FaChevronCircleDown } from 'react-icons/fa'
import React, { useState, Children, FC } from 'react'
import { usePathname } from 'next/navigation'

type DropDownProperties = {
    title?: string;
    icon?: React.ReactNode;
    children?: React.ReactNode;
    show?: boolean;
}

interface ChildWithProps{
    href: string;
}

export default function DropdownMenu({title, icon, children, show}:DropDownProperties){

    const path = usePathname();

    show = show ?? (function(){
        let _found = false;
        Children.map(children, (child: React.ReactNode) => {
            if(React.isValidElement<ChildWithProps>(child))
                if(path.endsWith(child.props.href))
                    _found = true
        });

        return _found
    })()


    const [drop, setDrop] = useState(show)
    function ToggleMenu(){
        setDrop(!drop)
    }

    let elementCount = Children.count(children)

    return(
        <div className={`transition-all p-2 overflow-hidden`} style={{
            height: drop ? 56 + 42 * elementCount : 56
        }}>
            <div className="flex flex-col w-auto">
                <div onClick={() => ToggleMenu()} className={`rounded-sm transition-all p-2 gap-2 cursor-pointer flex justify-between place-items-center my-2 hover:bg-white ${show ? styles.dropDownActive : ""}`} >
                    <span className={`text-sm text-gray-900 font-bold flex gap-2`}>
                        { icon }
                        { title }
                    </span>
                    <FaChevronCircleDown size={16} style={{transform: `rotateZ(${drop ? 180 : 0}deg)`}} className={`transition-all text-gray-900`} />
                </div>
                <div className="flex gap-6">
                    <div className="bg-gray-300 ml-4" style={{
                        width: '2px',
                    }}></div>
                    <ul className="flex flex-1 flex-col gap-2">
                        { children }
                    </ul>
                </div>
            </div>
        </div>   
    )
}