import styles from "./layout.module.css"
import Image from 'next/image'

export default function LoginPageLayout({children}:{children: React.ReactNode}){

    return (
        <main className="flex bg-white-100 justify-center h-screen place-items-center">
            <div className="shadow-lg w-1/2 h-screen absolute top-0 left-0 bg-gray-200 z-0"></div>
            <div className="shadow-inner w-1/2 h-screen absolute top-0 right-0 z-0 bg-gradient-to-b from-cyan-600 to-blue-400"></div>
            <section className={`bg-gray-100 z-20 rounded shadow-2xl ${styles.section}`}>
                {children}
            </section>
            <aside className={`hidden lg:block bg-gray-200 z-10 rounded shadow-2xl ${styles.aside}`}>
                <img src="https://zpy-customer-communication-cms-strapi-images-2.s3.amazonaws.com/DETRAN_CE_396b89aa3a.png" alt="footer" />
            </aside>
        </main>
    )

}