"use client"
import { usePathname } from 'next/navigation';
import styles from './styles/Input.module.css'
import Link from 'next/link';

type IconButtonProperties = {
    title?: string;
    icon?: React.ReactNode;
    color?: string;
    href?: string;
    className?: string;
}

export default function IconButton({ title, icon, color, href, className }:IconButtonProperties){

    const path = usePathname()

    let applyColor = color ? `btn_${color}_hover` : false

    const isActive = href ? path.endsWith(href) : false

    return (
        <div className="transition-all px-2 overflow-hidden mt-2">
            <Link href={href ?? ""}>
                <div className={`transition-all flex flex-col w-auto hover:bg-white rounded-sm ${className} ${applyColor ? styles[applyColor] : ""} ${isActive ? styles.btnActive : ""}`}>
                    <button className="flex p-2 gap-2 place-items-center">
                        <span className={`text-gray-900`}>{ icon }</span>
                        <span className={`text-sm font-bold text-gray-900 flex gap-2`}>
                            { title }
                        </span>
                    </button>
                </div>
            </Link>
        </div>
    )
}