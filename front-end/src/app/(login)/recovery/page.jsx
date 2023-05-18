import Link from 'next/link'
import Input from '@/components/Input'
import Button from '@/components/Button'

export default async function RecoveryPassword(){

    return (
        <div className="flex flex-col">
            <div className="flex place-items-center w-20 h-20 p-3 mt-8 m-2 bg-white rounded-lg shadow-lg place-self-center">
                <img src="https://www.seinfra.ce.gov.br/wp-content/uploads/sites/10/2019/08/logo-detran.png" alt="logo" />
            </div>

            <div className="mt-4 place-self-center text-2xl font-bold">Recuperação de senha</div>
            <p className="mt-2 text-gray-600 text-sm px-12">Ao clicar no botão abaixo, será enviado um email com o link para prosseguir com a recuperação da conta.</p>
            <form className='w-full px-12 mt-2 place-self-center'>
                <Input type="email" placeholder='exemplo@email.com' label='Email'/>

                <div className="flex mt-2 place-items-center justify-end">
                    <Link className="text-sm text-sky-900 transition underline hover:text-sky-700" href="/login">Retornar ao login</Link>
                </div>

                <div className="flex mt-8">
                    <Button className="w-full">Enviar</Button>
                </div>
            </form>

        </div>
    )

}