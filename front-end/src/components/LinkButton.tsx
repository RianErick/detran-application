"use client"
import { usePathname } from 'next/navigation';
import styles from './styles/Input.module.css'
import Link from 'next/link';

type IconButtonProperties = {
    title?: string;
    color?: string;
    href?: string;
}

export default function IconButton({ title, color, href }:IconButtonProperties){

    const path = usePathname()
    let applyColor = color ? `btn_${color}_hover` : false
    const isActive = href ? path.endsWith(href) : false

    return (
        <Link href={href ?? ""}>
            <button className={`transition hover:bg-blue-100 rounded w-full text-left text-sm bg-white p-2 ${applyColor ? styles[applyColor] : ""} ${isActive ? styles.btnActive : ""}`}>
                { title }
            </button>
        </Link>
    )
}